package com.mooc.cms.manager.service.impl;

import com.mooc.cms.manager.dao.CmsSiteRepository;
import com.mooc.cms.manager.service.CmsSiteService;
import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.response.CmsCode;
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
    public CmsResult<CmsSite> addSite(CmsSite cmsSite) {
        CmsSite cmsSite1 = cmsSiteRepository.findBySiteNameAndSiteDomainAndSitePortAndSiteWebPath(cmsSite.getSiteName(),cmsSite.getSiteDomain(),cmsSite.getSitePort(),cmsSite.getSiteWebPath());
        //如果已存在，则抛错
        if (cmsSite1 != null) {
            ExceptionCast.cast(CmsCode.CMS_SITE_ADD_ALREADY_EXIST);
        }
        CmsSite save = cmsSiteRepository.save(cmsSite);
        return new CmsResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CmsResult<CmsSite> updateSite(CmsSite cmsSite) {
        Optional<CmsSite> byId = cmsSiteRepository.findById(cmsSite.getSiteId());
        if (!byId.isPresent()) {
            ExceptionCast.cast(CmsCode.CMS_SITE_UPDATE_NOT_EXIST);
        }
        CmsSite update = cmsSiteRepository.save(cmsSite);
        return new CmsResult<>(CommonCode.SUCCESS, update);
    }

}

