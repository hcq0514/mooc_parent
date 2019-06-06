package com.mooc.course.controller;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.course.service.CourseBaseService;
import com.mooc.model.course.CourseBase;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("course/base")
public class CourseBaseController {

    @Autowired
    CourseBaseService courseBaseService;

    @GetMapping("/myCourse/{page}/{size}/{userId}")
    public QueryResponseResult findList(@PathVariable("page") int page, @PathVariable("size") int size, @PathVariable("userId") String userId) {
        CourseBase courseBase = new CourseBase();
        courseBase.setUserId(userId);
        QueryResponseResult list = courseBaseService.findList(page, size, null);
        return list;
    }

    @GetMapping("/get/{id}")
    public CourseBase getById(@PathVariable("id") String id) {
        return courseBaseService.getById(id);
    }

    @PostMapping("/add")
    public CommonResult add(@RequestBody CourseBase coursebase) {
        return courseBaseService.add(coursebase);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody CourseBase courseBase) {
        return courseBaseService.update(courseBase);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        return courseBaseService.deleteById(id);
    }

}

