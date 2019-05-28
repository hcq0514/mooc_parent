package com.mooc.cms.manager.controller;

import com.mooc.cms.manager.service.impl.CmsPageServiceImpl;
import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cmsPage")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    CmsPageServiceImpl cmsPageServiceImpl;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")
            int size, QueryPageRequest queryPageRequest) {
        return cmsPageServiceImpl.findList(page, size, queryPageRequest);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsPageServiceImpl.addPage(cmsPage);
    }

    @Override
    @PutMapping("/update")
    public CmsPageResult update(@RequestBody CmsPage cmsPage) {
        return cmsPageServiceImpl.updatePage(cmsPage);
    }

}

