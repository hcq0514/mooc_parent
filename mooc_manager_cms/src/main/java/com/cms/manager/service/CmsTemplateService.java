package com.cms.manager.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.cms.response.CmsResult;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
public interface CmsTemplateService {
    /**
     * 获取所有数据
     * @return
     */
     QueryResponseResult findAll();

    CmsResult<CmsTemplate> add(CmsTemplate cmsTemplate);

    CmsResult<CmsTemplate> update(CmsTemplate cmsTemplate);
}
