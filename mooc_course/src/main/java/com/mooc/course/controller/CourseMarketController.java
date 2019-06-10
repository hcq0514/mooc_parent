package com.mooc.course.controller;

import com.mooc.course.service.CourseMarketService;
import com.mooc.model.course.CourseMarket;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/market")
public class CourseMarketController {

    @Autowired
    CourseMarketService courseMarketService;

//    @GetMapping("/list/{courseId}")
//    public List findList(@PathVariable("courseId") String courseId) {
//        return courseMarketService.findList(courseId);
//    }


    @GetMapping("/get/{id}")
    public CourseMarket getById(@PathVariable("id") String id) {
        return courseMarketService.getById(id);
    }

    @PostMapping("/add")
    public CommonResult add(@RequestBody CourseMarket courseMarket) {
        return courseMarketService.add(courseMarket);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody CourseMarket courseMarket) {
        return courseMarketService.update(courseMarket);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        return courseMarketService.deleteById(id);
    }

}

