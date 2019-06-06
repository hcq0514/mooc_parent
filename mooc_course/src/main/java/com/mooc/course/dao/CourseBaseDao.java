package com.mooc.course.dao;

import com.mooc.model.course.CourseBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CourseBaseDao  extends JpaRepository<CourseBase,String> {
}
