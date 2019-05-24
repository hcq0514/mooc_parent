package com.cms.manager.controller;

import com.cms.manager.service.PageService;
import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.request.QueryPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cmsPage")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    PageService pageService;
    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")
            int size, QueryPageRequest queryPageRequest) {
        return pageService.findList(page,size,queryPageRequest);
    }

}

