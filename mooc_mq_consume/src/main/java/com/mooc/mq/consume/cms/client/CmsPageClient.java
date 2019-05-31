package com.mooc.mq.consume.cms.client;

import com.mooc.api.cms.CmsPageControllerApi;
import com.mooc.model.cms.CmsPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("mooc-manager-cms-service")
public interface CmsPageClient extends CmsPageControllerApi{

    @RequestMapping("/get/{id}")
    CmsPage getById(@PathVariable("id") String id);
}
