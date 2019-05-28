package com.mooc.cms.manager.dao;

import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CmsTemplateRepository extends MongoRepository<CmsTemplate,String> {

    CmsTemplate findBySiteIdAndTemplateName(String siteId,String templateName);


}
