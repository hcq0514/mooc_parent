package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsPageRepository;
import com.mooc.cms.manager.service.CmsPageService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsCode;
import com.mooc.model.cms.response.CmsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Service
public class CmsPageServiceImpl implements CmsPageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    MongoTemplate mongoTemplate;

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
        if (queryPageRequest == null) {
            queryPageRequest = new QueryPageRequest();
        }
        if (page <= 0) {
            page = 1;
        }
        //为了适应mongodb的接口将页码减1
        page = page - 1;
        if (size <= 0) {
            size = 20;
        }
//分页对象
        Pageable pageable = PageRequest.of(page, size);
//分页查询
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
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
        Optional<CmsPage> byId = cmsPageRepository.findById(cmsPage.getPageId());
        if (!byId.isPresent()) {
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
}

