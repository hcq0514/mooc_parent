package com.mooc.course.service.impl;

import com.mooc.course.dao.SysDictionaryDao;
import com.mooc.course.service.SysDictionaryService;
import com.mooc.model.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/5
 */
@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {
    @Autowired
    SysDictionaryDao sysDictionaryDao;

    @Override
    public SysDictionary getByDicType(String dicType) {
        SysDictionary byDType = sysDictionaryDao.findByDType(dicType);
        return byDType;
    }
}
