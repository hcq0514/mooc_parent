package com.cms.manager.service;

import com.cms.manager.dao.CmsPageRepository;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PageService {
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


    public CmsPageResult addPage(CmsPage cmsPage) {
        CmsPage cmsPage1 = cmsPageRepository.findByPageNameAndSiteIdAndPageWebPath(cmsPage.getPageName(), cmsPage.getSiteId(), cmsPage.getPageWebPath());
        //如果已存在，则抛错
        if (cmsPage1 != null) {
            return new CmsPageResult(CommonCode.FAIL, null);
        }
        CmsPage save = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, save);
    }


    public CmsPageResult updatePage(CmsPage cmsPage) {
        Optional<CmsPage> byId = cmsPageRepository.findById(cmsPage.getPageId());
        if (!byId.isPresent()) {
            return new CmsPageResult(CommonCode.FAIL, null);
        }
        CmsPage update = cmsPageRepository.save(cmsPage);
        return new CmsPageResult(CommonCode.SUCCESS, update);
    }
}

