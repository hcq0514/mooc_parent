package com.mooc.course.dao;

import com.mooc.model.course.CourseTeachPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CourseTeachPlanDao extends JpaRepository<CourseTeachPlan,String> {
    List findByCourseid(String courseId);
}
