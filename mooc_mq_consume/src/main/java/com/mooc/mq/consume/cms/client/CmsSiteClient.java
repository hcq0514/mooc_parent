package com.mooc.mq.consume.cms.client;

import com.mooc.api.cms.CmsSiteControllerApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("manager-cms-service")
public interface CmsSiteClient extends CmsSiteControllerApi {

}
