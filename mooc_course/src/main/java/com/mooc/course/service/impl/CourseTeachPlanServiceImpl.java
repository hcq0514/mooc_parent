package com.mooc.course.service.impl;

import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.course.dao.CourseTeachPlanDao;
import com.mooc.course.service.CourseTeachPlanService;
import com.mooc.model.course.CourseTeachPlan;
import com.mooc.model.errorCode.CourseErrorCode;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseTeachPlanServiceImpl implements CourseTeachPlanService {

    @Autowired
    CourseTeachPlanDao courseTeachPlanDao;


    @Override
    public List findByCourseId(String couseId) {
        return courseTeachPlanDao.findByCourseid(couseId);
    }

    @Override
    public CourseTeachPlan getById(String id) {
        Optional<CourseTeachPlan> courseTeachPlanOptional = courseTeachPlanDao.findById(id);
        return courseTeachPlanOptional.orElse(null);
    }

    @Override
    public CommonResult add(CourseTeachPlan courseteachplan) {
        CourseTeachPlan save = courseTeachPlanDao.save(courseteachplan);
        return new CommonResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CommonResult update(CourseTeachPlan courseteachplan) {
        Optional<CourseTeachPlan> byId = courseTeachPlanDao.findById(courseteachplan.getId());
        if (!byId.isPresent()) {
            ExceptionCast.cast(CourseErrorCode.COURSE_BASE_NOT_EXIST);
        }
        CourseTeachPlan update = courseTeachPlanDao.save(courseteachplan);
        return new CommonResult<>(CommonCode.SUCCESS, update);
    }

    @Override
    public CommonResult deleteById(String id) {
        Optional<CourseTeachPlan> byId = courseTeachPlanDao.findById(id);
        if (!byId.isPresent()) {
            ExceptionCast.cast(CourseErrorCode.COURSE_BASE_NOT_EXIST);
        }
        courseTeachPlanDao.deleteById(id);
        return new CommonResult<>(CommonCode.SUCCESS, null);
    }
}
