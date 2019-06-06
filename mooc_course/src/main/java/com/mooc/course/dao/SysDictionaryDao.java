package com.mooc.course.dao;

import com.mooc.model.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SysDictionaryDao extends MongoRepository<SysDictionary,String> {
    SysDictionary findByDType(String dicType);
}
