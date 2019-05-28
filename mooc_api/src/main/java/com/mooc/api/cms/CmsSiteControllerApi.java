package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.response.CmsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms站点管理接口", description = "cms站点管理接口")
public interface CmsSiteControllerApi {
    @ApiOperation("查询站点列表")
    QueryResponseResult findAll();

    @ApiOperation("新增站点")
    CmsResult addSite(CmsSite CmsSite);

    @ApiOperation("修改页面")
    CmsResult<CmsSite> updateSite(CmsSite CmsSite);

}

