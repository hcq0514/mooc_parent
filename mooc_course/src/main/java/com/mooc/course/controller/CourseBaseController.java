package com.mooc.course.controller;

import com.mooc.course.service.CourseBaseService;
import com.mooc.model.course.CourseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course/base")
public class CourseBaseController {

    @Autowired
    CourseBaseService courseBaseService;


    @GetMapping("/get/{id}")
    public CourseBase getById(@PathVariable("id") String id) {
        return courseBaseService.getById(id);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody CourseBase coursebase) {
        return courseBaseService.save(coursebase);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CourseBase courseBase) {
        return courseBaseService.saveOrUpdate(courseBase);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return courseBaseService.removeById(id);
    }

}

