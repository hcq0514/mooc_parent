package com.cms.manager.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.response.CmsPageResult;
import com.mooc.model.cms.response.CmsResult;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
public interface CmsSiteService {
    /**
     * 获取所有数据
     * @return
     */
     QueryResponseResult findAll();

    CmsResult<CmsSite> addSite(CmsSite cmsSite);

    CmsResult<CmsSite> updateSite(CmsSite cmsSite);
}
