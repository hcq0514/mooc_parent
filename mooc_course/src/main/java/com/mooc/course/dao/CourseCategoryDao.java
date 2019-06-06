package com.mooc.course.dao;

import com.mooc.model.course.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CourseCategoryDao extends JpaRepository<CourseCategory,String> {

    List<CourseCategory> findByParentid(String id);


}
