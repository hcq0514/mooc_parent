package com.mooc.cms.manager.service;

import com.mooc.model.cms.CmsConfig;
import com.mooc.model.cms.CmsConfigModel;

import java.util.List;

/**
 * CMS配置(轮播图，精品推荐等)
 *
 * @author : hcq
 * @date : 2019/5/28
 */
public interface CmsConfigService {
    CmsConfig getById(String id);

    List<CmsConfigModel> getModelById(String id);

}
