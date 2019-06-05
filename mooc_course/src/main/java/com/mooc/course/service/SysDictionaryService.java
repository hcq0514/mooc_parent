package com.mooc.course.service;

import com.mooc.model.system.SysDictionary;

/**
 * @author : hcq
 * @date : 2019/6/5
 */
public interface SysDictionaryService {
    SysDictionary getByDicType(String Type);
}
