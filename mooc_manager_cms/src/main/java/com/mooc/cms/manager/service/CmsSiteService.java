package com.mooc.cms.manager.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.result.CommonResult;

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

    CommonResult<CmsSite> addSite(CmsSite cmsSite);

    CommonResult<CmsSite> updateSite(CmsSite cmsSite);

    CmsSite getById(String id);
}
