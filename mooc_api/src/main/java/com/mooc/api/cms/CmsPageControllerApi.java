package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms页面管理接口", description = "cms页面管理接口，提供页面的增、删、改、查")
@RequestMapping("cmsPage")
public interface CmsPageControllerApi {
    @ApiOperation("分页查询页面列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, example = "0", paramType = "path", dataType = "int"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, example = "10", paramType = "path", dataType = "int")
    })
    @GetMapping("/list/{page}/{size}")
    QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")
            int size, QueryPageRequest queryPageRequest);

    @ApiOperation("查询页面")
    @GetMapping("/get/{id}")
    CmsPage getById(@PathVariable("id") String id);

    @ApiOperation("新增页面")
    @PostMapping("/add")
    CmsPageResult add(@RequestBody CmsPage cmsPage);

    @ApiOperation("修改页面")
    @PutMapping("/update")
    CmsPageResult update(@RequestBody CmsPage cmsPage);

    @ApiOperation("删除页面")
    @DeleteMapping("/delete/{pageId}")
    CmsPageResult delete(@PathVariable("pageId") String pageId);

    @ApiOperation("预览页面")
    @GetMapping("preview/{pageId}")
    void previewPage(@PathVariable("pageId") String pageId, HttpServletResponse response);
}

