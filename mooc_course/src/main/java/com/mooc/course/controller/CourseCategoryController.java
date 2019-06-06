package com.mooc.course.controller;

import com.mooc.course.service.CourseCategoryService;
import com.mooc.model.course.CourseCategory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("course/category")
public class CourseCategoryController {

    @Autowired
    CourseCategoryService  courseCategoryService;


    @ApiOperation(value = "查询所有类别列表")
    @GetMapping("/list")
    public CourseCategory list() {
        return courseCategoryService.buildCategoryNode();
    }


}

