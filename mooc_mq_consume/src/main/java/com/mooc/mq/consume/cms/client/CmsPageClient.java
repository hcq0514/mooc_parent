package com.mooc.mq.consume.cms.client;

import com.mooc.api.cms.CmsPageControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("manager-cms-service")
public interface CmsPageClient extends CmsPageControllerApi{

}
