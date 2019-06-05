package com.mooc.course.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mooc.course.service.CourseTeachPlanService;
import com.mooc.model.course.CourseTeachPlan;
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
        CourseTeachPlan courseTeachPlan = new CourseTeachPlan();
        courseTeachPlan.setCourseid(courseId);
        List<CourseTeachPlan> list = courseTeachPlanService.list(new QueryWrapper<>(courseTeachPlan));
        return list;
    }


    @GetMapping("/get/{id}")
    public CourseTeachPlan getById(@PathVariable("id") String id) {
        return courseTeachPlanService.getById(id);
    }

    //todo 课程等级这边先写死，后期再写
    @PostMapping("/add")
    public boolean add(@RequestBody CourseTeachPlan courseteachplan) {
        courseteachplan.setGrade("3");
        return courseTeachPlanService.save(courseteachplan);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody CourseTeachPlan courseteachplan) {
        return courseTeachPlanService.saveOrUpdate(courseteachplan);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") String id) {
        return courseTeachPlanService.removeById(id);
    }

}

