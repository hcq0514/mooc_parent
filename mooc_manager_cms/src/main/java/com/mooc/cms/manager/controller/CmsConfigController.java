package com.mooc.cms.manager.controller;

import com.mooc.api.cms.CmsConfigControllerApi;
import com.mooc.cms.manager.service.CmsConfigService;
import com.mooc.model.cms.CmsConfig;
import com.mooc.model.cms.CmsConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/5/28
 * 0
 */
@RestController
@RequestMapping("cmsConfig")
public class CmsConfigController implements CmsConfigControllerApi {

    @Autowired
    CmsConfigService cmsConfigService;

    @Override
    @GetMapping("{id}")
    public CmsConfig getById(@PathVariable("id") String id) {
        return cmsConfigService.getById(id);
    }

    @Override
    @GetMapping("model/{id}")
    public List<CmsConfigModel> getModelById(@PathVariable("id") String id) {
        return cmsConfigService.getModelById(id);
    }
}

