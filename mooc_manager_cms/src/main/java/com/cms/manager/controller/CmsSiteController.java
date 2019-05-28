package com.cms.manager.controller;

import com.cms.manager.service.CmsSiteService;
import com.cms.manager.service.impl.CmsPageServiceImpl;
import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.api.cms.CmsSiteControllerApi;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import com.mooc.model.cms.response.CmsResult;
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
    @GetMapping("/all")
    public QueryResponseResult findAll() {
        return cmsSiteService.findAll();
    }

    @Override
    @PostMapping("/add")
    public CmsResult<CmsSite> add(@RequestBody CmsSite cmsSite) {
        return cmsSiteService.addSite(cmsSite);
    }

    @Override
    @PutMapping("/update")
    public CmsResult<CmsSite> update(@RequestBody CmsSite cmsSite) {
        return cmsSiteService.updateSite(cmsSite);
    }
}

