package com.mooc.course.service.impl;

import com.mooc.course.service.CourseTeachPlanService;
import com.mooc.model.course.CourseTeachPlan;
import com.mooc.model.result.CommonResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseTeachPlanServiceImpl implements CourseTeachPlanService {


    @Override
    public List findByCourseId(String couseId) {
        return null;
    }

    @Override
    public CourseTeachPlan getById(String id) {
        return null;
    }

    @Override
    public CommonResult add(CourseTeachPlan courseteachplan) {
        return null;
    }

    @Override
    public CommonResult update(CourseTeachPlan courseteachplan) {
        return null;
    }

    @Override
    public CommonResult deleteById(String id) {
        return null;
    }
}
