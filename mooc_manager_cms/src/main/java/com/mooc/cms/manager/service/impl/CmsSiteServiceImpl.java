package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsSiteRepository;
import com.mooc.cms.manager.service.CmsSiteService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.errorCode.CmsErrorCode;
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
public class CmsSiteServiceImpl implements CmsSiteService {

    @Autowired
    CmsSiteRepository cmsSiteRepository;

    @Override
    public QueryResponseResult findAll() {
        List<CmsSite> all = cmsSiteRepository.findAll();
        QueryResult<CmsSite> queryResult = new QueryResult<>();
        queryResult.setList(all);
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public CommonResult<CmsSite> addSite(CmsSite cmsSite) {
        CmsSite cmsSite1 = cmsSiteRepository.findBySiteNameAndSiteDomainAndSitePortAndSiteWebPath(cmsSite.getSiteName(),cmsSite.getSiteDomain(),cmsSite.getSitePort(),cmsSite.getSiteWebPath());
        //如果已存在，则抛错
        if (cmsSite1 != null) {
            ExceptionCast.cast(CmsErrorCode.CMS_SITE_ADD_ALREADY_EXIST);
        }
        CmsSite save = cmsSiteRepository.save(cmsSite);
        return new CommonResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CommonResult<CmsSite> updateSite(CmsSite cmsSite) {
        Optional<CmsSite> byId = cmsSiteRepository.findById(cmsSite.getSiteId());
        if (!byId.isPresent()) {
            ExceptionCast.cast(CmsErrorCode.CMS_SITE_NOT_EXIST);
        }
        CmsSite update = cmsSiteRepository.save(cmsSite);
        return new CommonResult<>(CommonCode.SUCCESS, update);
    }

    @Override
    public CmsSite getById(String id) {
        Optional<CmsSite> optional = cmsSiteRepository.findById(id);
        boolean present = optional.isPresent();
        if (present) {
            return optional.get();
        }
        return null;
    }

}

