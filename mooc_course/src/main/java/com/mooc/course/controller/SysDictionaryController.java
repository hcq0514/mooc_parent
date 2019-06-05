package com.mooc.course.controller;

import com.mooc.course.service.SysDictionaryService;
import com.mooc.model.system.SysDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course/dictionary")
public class SysDictionaryController {

    @Autowired
    SysDictionaryService sysDictionaryService;


    /**
     * todo 后期把系统模块的应用抽出来。
     * @param dicType
     * @return
     */
    @GetMapping("/get/{dicType}")
    public SysDictionary getByType(@PathVariable("dicType") String dicType) {
        return sysDictionaryService.getByDicType(dicType);
    }


}

