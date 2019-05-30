package com.mooc.cms.manager.service.impl;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mooc.cms.manager.dao.CmsPageRepository;
import com.mooc.cms.manager.dao.CmsTemplateRepository;
import com.mooc.cms.manager.service.CmsConfigService;
import com.mooc.cms.manager.service.CmsPageService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsConfigModel;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsCode;
import com.mooc.model.cms.response.CmsPageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.ByteArrayOutputStream;
import java.util.*;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Service
public class CmsPageServiceImpl implements CmsPageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    CmsConfigService cmsConfigService;
    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    /**
     * 这个地方不能用autowire注入 会导致静态化时只读模版而不能使用字符串，不知道为什么
     */
    private final static TemplateEngine templateEngine = new TemplateEngine();

    /**
     * 页面列表分页查询
     *
     * @param page             当前页码
     * @param size             页面显示个数
     * @param queryPageRequest 查询条件
     * @return 页面列表
     */
    @Override
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        //条件匹配器
        //页面名称模糊查询，需要自定义字符串的匹配器实现模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
        CmsPage cmsPage = new CmsPage();
        //站点ID
        if (StringUtils.isNotEmpty(queryPageRequest.getPageId())) {
            cmsPage.setPageId(queryPageRequest.getPageId());
        }
        //站点ID
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
        //页面别名
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
        //创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        //页码
        page = page - 1;
        //分页对象
        Pageable pageable = PageRequest.of(page, size);
        //分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }

    @Override
    public CmsPageResult getById(String id) {
        Optional<CmsPage> optional = cmsPageRepository.findById(id);
        return optional.map(cmsPage1 -> new CmsPageResult(CommonCode.SUCCESS, cmsPage1))
                .orElseGet(() -> new CmsPageResult(CommonCode.SUCCESS, null));
    }


    @Override
    public CmsPageResult addPage(CmsPage cmsPage) {
        CmsPage cmsPage1 = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        //如果已存在，则抛错
        if (cmsPage1 != null) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_ADD_ALREADY_EXIST);
        }
        cmsPage.setPageCreateTime(new Date());
        CmsPage save = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, save);
    }

    @Override
    public CmsPageResult updatePage(CmsPage cmsPage) {
        Optional<CmsPage> optionCmsPage = cmsPageRepository.findById(cmsPage.getPageId());
        if (!optionCmsPage.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOT_EXIST);
        }
        CmsPage update = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, update);
    }

    @Override
    public CmsPageResult delete(String pageId) {
        Optional<CmsPage> cmsPage = cmsPageRepository.findById(pageId);
        if (!cmsPage.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOT_EXIST);
        }
        cmsPageRepository.deleteById(pageId);
        return new CmsPageResult(CommonCode.SUCCESS, null);
    }

    /**
     * 轮播图模版预览
     * 1. 获取模版数据
     * 1.1 从cms_config表里取到轮播图的请求地址，写入到cms_page的dataUrl里面
     * 1.2 根据page_id取得dataUrl
     * 2. 获取模版页面
     * 2.1 首先制作一个模版存入到cms_template页面里，模版页面存储到GridFS里面，并保存GridFS的id到template里
     * 2.2 根据page_id取得模版页面
     * 3. 利用thymleaf模版静态化生成页面
     * todo 现在只有轮播图可以使用预览页面，后期换成freemark或者重新寻求解决方案
     */
    @Override
    public String previewPage(String pageId) {
        Optional<CmsPage> optional = cmsPageRepository.findById(pageId);
        if (!optional.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_PAGE_NOT_EXIST);
        }
        CmsPage cmsPage = optional.get();
        List<CmsConfigModel> models = cmsConfigService.getModelById(cmsPage.getDataUrl());
        //获取模版页面
        Optional<CmsTemplate> optionalCmsTemplate = cmsTemplateRepository.findById(cmsPage.getTemplateId());
        if (!optionalCmsTemplate.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_TEMPLATE_NOT_EXIST);
        }
        CmsTemplate cmsTemplate = optionalCmsTemplate.get();
        //根据id查询文件
        GridFSFile gridFSFile =
                gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(cmsTemplate.getTemplateFileId())));
        //打开下载流对象
        if (gridFSFile == null) {
            ExceptionCast.cast(CmsCode.CMS_TEMPLATE_FILE_NOT_EXIST);
        }
        // mongo-java-driver3.x以上的版本就变成了这种方式获取
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 获取Mongodb中文件的缓存输出流
        gridFSBucket.downloadToStream(gridFSFile.getId(), byteArrayOutputStream);
        String template = byteArrayOutputStream.toString();
        //静态化生成
        Context context = new Context();
        Map map = new HashMap();
        map.put("models", models);
        context.setVariables(map);
        return templateEngine.process(template, context);
    }
}

