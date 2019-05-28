package com.mooc.cms.manager.dao;

import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsSite;
import org.bouncycastle.crypto.prng.EntropyUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CmsSiteRepository extends MongoRepository<CmsSite,String> {

    /**
     *
     * @param siteName
     * @param siteDomain
     * @param sitePore
     * @param siteWebPath
     * @return
     */
    CmsSite findBySiteNameAndSiteDomainAndSitePortAndSiteWebPath(String siteName,String siteDomain,String sitePore,String siteWebPath);

}
