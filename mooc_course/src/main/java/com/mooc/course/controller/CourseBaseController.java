package com.mooc.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.course.service.CourseBaseService;
import com.mooc.model.course.CourseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course/base")
public class CourseBaseController {

    @Autowired
    CourseBaseService courseBaseService;

    @GetMapping("/myCourse/{page}/{size}/{userId}")
    public IPage<CourseBase> findList(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("userId") String userId) {
        CourseBase courseBase = new CourseBase();
        courseBase.setUserId(userId);
        return courseBaseService.page(new Page<>(page, size),new QueryWrapper<>(courseBase));
    }

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

