package com.mooc.cms.manager.controller;

import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.cms.manager.service.CmsConfigService;
import com.mooc.cms.manager.service.CmsPageService;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

    @Override
    @GetMapping("preview/{pageId}")
    public void previewPage(@PathVariable("pageId") String pageId, HttpServletResponse response) {
        String pageHtml = cmsPageService.previewPage(pageId);
        if(StringUtils.isNotEmpty(pageHtml)){
            try {
                ServletOutputStream outputStream = response.getOutputStream();
                outputStream.write(pageHtml.getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

