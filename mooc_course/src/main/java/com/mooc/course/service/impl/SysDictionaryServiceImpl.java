package com.mooc.course.service.impl;

import com.mooc.common.exception.ExceptionCast;
import com.mooc.course.reposity.SysDictionaryRepository;
import com.mooc.course.service.SysDictionaryService;
import com.mooc.model.errorCode.SysErrorCode;
import com.mooc.model.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/6/5
 */
@Service
public class SysDictionaryServiceImpl implements SysDictionaryService {
    @Autowired
    SysDictionaryRepository sysDictionaryRepository;

    @Override
    public SysDictionary getByDicType(String dicType) {
        SysDictionary byDType = sysDictionaryRepository.findByDType(dicType);
        return byDType;
    }
}
