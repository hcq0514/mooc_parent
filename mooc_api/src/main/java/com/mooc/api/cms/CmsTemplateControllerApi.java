package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms模版管理接口", description = "cms模版管理接口")
public interface CmsTemplateControllerApi {
    @ApiOperation("查询全部模版")
    QueryResponseResult findAll();

    @ApiOperation("新增模版")
    CommonResult<CmsTemplate> add(CmsTemplate cmsTemplate);

    @ApiOperation("修改模版")
    CommonResult<CmsTemplate> update(CmsTemplate cmsTemplate);

}

