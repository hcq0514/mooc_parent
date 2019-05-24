package com.mooc.api.cms;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.request.QueryPageRequest;

public interface CmsPageControllerApi {
     QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) ;
}

