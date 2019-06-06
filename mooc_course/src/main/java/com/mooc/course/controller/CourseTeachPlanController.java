package com.mooc.course.controller;

import com.mooc.course.service.CourseTeachPlanService;
import com.mooc.model.course.CourseTeachPlan;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course/teachPlan")
public class CourseTeachPlanController {

    @Autowired
    CourseTeachPlanService courseTeachPlanService;

    @GetMapping("/list/{courseId}")
    public List findList(@PathVariable("courseId") String courseId) {
        return courseTeachPlanService.findByCourseId(courseId);
    }


    @GetMapping("/get/{id}")
    public CourseTeachPlan getById(@PathVariable("id") String id) {
        return courseTeachPlanService.getById(id);
    }

    //todo 课程等级这边先写死，后期再写
    @PostMapping("/add")
    public CommonResult add(@RequestBody CourseTeachPlan courseteachplan) {
        courseteachplan.setGrade("3");
        return courseTeachPlanService.add(courseteachplan);
    }

    @PutMapping("/update")
    public CommonResult update(@RequestBody CourseTeachPlan courseteachplan) {
        return courseTeachPlanService.update(courseteachplan);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResult delete(@PathVariable("id") String id) {
        return courseTeachPlanService.deleteById(id);
    }

}

