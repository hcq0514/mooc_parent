package com.mooc.cms.manager.controller;

import com.mooc.cms.manager.service.CmsSiteService;
import com.mooc.api.cms.CmsSiteControllerApi;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hcq
 * @date : 2019/5/28
 * 0
 */
@RestController
@RequestMapping("cmsSite")
public class CmsSiteController implements CmsSiteControllerApi {

    @Autowired
    CmsSiteService cmsSiteService;

    @Override
    @GetMapping("/get/{id}")
    public CmsSite getById(@PathVariable("id") String id) {
        return cmsSiteService.getById(id);
    }

    @Override
    @GetMapping("/all")
    public QueryResponseResult findAll() {
        return cmsSiteService.findAll();
    }

    @Override
    @PostMapping("/add")
    public CommonResult<CmsSite> add(@RequestBody CmsSite cmsSite) {
        return cmsSiteService.addSite(cmsSite);
    }

    @Override
    @PutMapping("/update")
    public CommonResult<CmsSite> update(@RequestBody CmsSite cmsSite) {
        return cmsSiteService.updateSite(cmsSite);
    }
}

