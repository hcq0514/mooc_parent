package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.ResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的增、删、改、查")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, example = "0", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, example = "10", paramType = "path", dataType = "int")
    })
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    @ApiOperation("查询页面")
    CmsPageResult getById(String pageId);

    @ApiOperation("新增页面")
    CmsPageResult add(CmsPage cmsPage);

    @ApiOperation("修改页面")
    CmsPageResult update(CmsPage cmsPage);

    @ApiOperation("删除页面")
    CmsPageResult delete(String pageId);

    @ApiOperation("预览页面")
    void previewPage(String pageId, HttpServletResponse response);
}

