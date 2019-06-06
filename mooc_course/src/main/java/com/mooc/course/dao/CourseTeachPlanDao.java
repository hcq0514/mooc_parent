package com.mooc.course.dao;

import com.mooc.model.course.CourseTeachPlan;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CourseTeachPlanDao extends JpaRepository<CourseTeachPlan,String> {
}
