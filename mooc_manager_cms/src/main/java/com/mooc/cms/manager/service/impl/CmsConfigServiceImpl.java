package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsConfigRepository;
import com.mooc.cms.manager.service.CmsConfigService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.model.cms.CmsConfig;
import com.mooc.model.cms.CmsConfigModel;
import com.mooc.model.errorCode.CmsErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Service
public class CmsConfigServiceImpl implements CmsConfigService {

    @Autowired
    CmsConfigRepository cmsConfigRepository;

    @Override
    public CmsConfig getById(String id) {
        Optional<CmsConfig> optional = cmsConfigRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public List<CmsConfigModel> getModelById(String id) {
        CmsConfig cmsConfig = this.getById(id);
        if (cmsConfig == null) {
            ExceptionCast.cast(CmsErrorCode.CMS_CONFIG_NOT_EXIST);
        }
        return cmsConfig.getModel();
    }
}

