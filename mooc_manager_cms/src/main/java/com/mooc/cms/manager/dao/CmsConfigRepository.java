package com.mooc.cms.manager.dao;

import com.mooc.model.cms.CmsConfig;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CmsConfigRepository extends MongoRepository<CmsConfig,String> {
}
