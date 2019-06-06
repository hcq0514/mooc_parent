package com.mooc.course.dao;

import com.mooc.model.course.CoursePre;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CoursePreDao extends JpaRepository<CoursePre,String> {
}
