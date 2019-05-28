package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsTemplateRepository;
import com.mooc.cms.manager.service.CmsTemplateService;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.cms.response.CmsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/5/28
 */
@Service
public class CmsTemplateServiceImpl implements CmsTemplateService {

    @Autowired
    CmsTemplateRepository cmsTemplateRepository;

    @Override
    public QueryResponseResult findAll() {
        List<CmsTemplate> all = cmsTemplateRepository.findAll();
        QueryResult<CmsTemplate> queryResult = new QueryResult<>();
        queryResult.setList(all);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public CmsResult<CmsTemplate> add(CmsTemplate cmsTemplate) {
        CmsTemplate CmsTemplate1 = cmsTemplateRepository.findBySiteIdAndTemplateName(cmsTemplate.getSiteId(), cmsTemplate.getTemplateName());
        //如果已存在，则抛错
        if (CmsTemplate1 != null) {
            return new CmsResult<>(CommonCode.FAIL, null);
        }
        CmsTemplate save = cmsTemplateRepository.save(cmsTemplate);
        return new CmsResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CmsResult<CmsTemplate> update(CmsTemplate cmsTemplate) {
        Optional<CmsTemplate> byId = cmsTemplateRepository.findById(cmsTemplate.getTemplateId());
        if (!byId.isPresent()) {
            return new CmsResult<>(CommonCode.FAIL, null);
        }
        CmsTemplate update = cmsTemplateRepository.save(cmsTemplate);
        return new CmsResult<>(CommonCode.SUCCESS, update);
    }

}

