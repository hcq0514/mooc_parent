package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.result.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Api(value = "cms站点管理接口", description = "cms站点管理接口")
@RestController
@RequestMapping("cmsSite")
public interface CmsSiteControllerApi {

    @ApiOperation("查询页面")
    @GetMapping("/get/{id}")
    CmsSite getById(@PathVariable("id") String id);

    @ApiOperation("查询站点列表")
    @GetMapping("/all")
    QueryResponseResult findAll();

    @ApiOperation("新增站点")
    @PostMapping("/add")
    CommonResult add(CmsSite CmsSite);

    @ApiOperation("修改页面")
    @PutMapping("/update")
    CommonResult<CmsSite> update(CmsSite CmsSite);

}

