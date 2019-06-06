package com.mooc.course.service;

import com.mooc.model.course.CourseTeachPlan;
import com.mooc.model.result.CommonResult;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
public interface CourseTeachPlanService  {
    List findByCourseId(String couseId);

    CourseTeachPlan getById(String id);

    CommonResult add(CourseTeachPlan courseteachplan);

    CommonResult update(CourseTeachPlan courseteachplan);

    CommonResult deleteById(String id);
}
