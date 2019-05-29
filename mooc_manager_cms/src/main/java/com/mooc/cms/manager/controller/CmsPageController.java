package com.mooc.cms.manager.controller;

import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.cms.manager.service.CmsConfigService;
import com.mooc.cms.manager.service.CmsPageService;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsConfigModel;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("cmsPage")
public class CmsPageController implements CmsPageControllerApi {

    @Autowired
    CmsPageService cmsPageService;

    @Autowired
    CmsConfigService cmsConfigService;

    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size")
            int size, QueryPageRequest queryPageRequest) {
        return cmsPageService.findList(page, size, queryPageRequest);
    }

    @Override
    @GetMapping("/get/{id}")
    public CmsPageResult getById(@PathVariable("id") String id) {
        return cmsPageService.getById(id);
    }

    @Override
    @PostMapping("/add")
    public CmsPageResult add(@RequestBody CmsPage cmsPage) {
        return cmsPageService.addPage(cmsPage);
    }

    @Override
    @PutMapping("/update")
    public CmsPageResult update(@RequestBody CmsPage cmsPage) {
        return cmsPageService.updatePage(cmsPage);
    }

    @Override
    @DeleteMapping("/delete/{pageId}")
    public CmsPageResult delete(@PathVariable("pageId") String pageId) {
        return cmsPageService.delete(pageId);
    }

    @GetMapping
    public ModelAndView testTh(ModelAndView modelAndView) {
        List<CmsConfigModel> models = cmsConfigService.getModelById("5a791725dd573c3574ee333f");
        modelAndView.setViewName("index_banner");
        modelAndView.addObject("models", models);
        return modelAndView;
    }

}

