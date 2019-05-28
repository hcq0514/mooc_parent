package com.mooc.cms.manager.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import com.mooc.model.cms.response.CmsPageResult;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
public interface CmsPageService {
    QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest);

    CmsPageResult addPage(CmsPage cmsPage);

    CmsPageResult updatePage(CmsPage cmsPage);
}
