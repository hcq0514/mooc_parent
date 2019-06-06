package com.mooc.course.dao;

import com.mooc.model.course.CourseTeachPlanMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

@Repository
public interface CourseTeachPlanMediaDao extends JpaRepository<CourseTeachPlanMedia,String> {
}
