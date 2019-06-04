package com.mooc.cms.manager.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.result.CommonResult;

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

    CommonResult<CmsTemplate> add(CmsTemplate cmsTemplate);

    CommonResult<CmsTemplate> update(CmsTemplate cmsTemplate);
}
