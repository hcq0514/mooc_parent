package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsTemplateRepository;
import com.mooc.cms.manager.service.CmsTemplateService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsTemplate;
import com.mooc.model.cms.response.CmsCode;
import com.mooc.model.result.CommonResult;
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
    public CommonResult<CmsTemplate> add(CmsTemplate cmsTemplate) {
        CmsTemplate exist = cmsTemplateRepository.findBySiteIdAndTemplateName(cmsTemplate.getSiteId(), cmsTemplate.getTemplateName());
        //如果已存在，则抛错
        if (exist != null) {
            ExceptionCast.cast(CmsCode.CMS_TEMPLATE_ADD_ALREADY_EXIST);
        }
        CmsTemplate save = cmsTemplateRepository.save(cmsTemplate);
        return new CommonResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CommonResult<CmsTemplate> update(CmsTemplate cmsTemplate) {
        Optional<CmsTemplate> exist = cmsTemplateRepository.findById(cmsTemplate.getTemplateId());
        if (!exist.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_TEMPLATE_NOT_EXIST);
        }
        CmsTemplate update = cmsTemplateRepository.save(cmsTemplate);
        return new CommonResult<>(CommonCode.SUCCESS, update);
    }

}

