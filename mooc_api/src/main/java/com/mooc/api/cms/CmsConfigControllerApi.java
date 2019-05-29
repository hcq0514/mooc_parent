package com.mooc.api.cms;

import com.mooc.model.cms.CmsConfig;
import com.mooc.model.cms.CmsConfigModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms配置管理接口", description = "cms配置管理接口")
public interface CmsConfigControllerApi {


    @ApiOperation("查询配置")
    CmsConfig getById(String id);

    @ApiOperation("查询配置")
    List<CmsConfigModel> getModelById(String id);


}

