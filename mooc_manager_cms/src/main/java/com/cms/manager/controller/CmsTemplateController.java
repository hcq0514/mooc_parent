package com.cms.manager.controller;

import com.cms.manager.service.CmsTemplateService;
import com.mooc.api.cms.CmsTemplateControllerApi;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.cms.response.CmsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hcq
 * @date : 2019/5/28
0 */
@RestController
@RequestMapping("cmsTemplate")
public class CmsTemplateController implements CmsTemplateControllerApi {

    @Autowired
    CmsTemplateService cmsTemplateService;

    @Override
    @GetMapping("/all")
    public QueryResponseResult findAll() {
        return cmsTemplateService.findAll();
    }


    @Override
    @PostMapping("/add")
    public CmsResult<CmsTemplate> add(@RequestBody  CmsTemplate cmsTemplate) {
        return cmsTemplateService.add(cmsTemplate);
    }

    @Override
    @PutMapping("/update")
    public CmsResult<CmsTemplate> update(@RequestBody  CmsTemplate cmsTemplate) {
        return cmsTemplateService.update(cmsTemplate);
    }
}

