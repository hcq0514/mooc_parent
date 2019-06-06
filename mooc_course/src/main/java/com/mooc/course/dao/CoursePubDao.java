package com.mooc.course.dao;

import com.mooc.model.course.CoursePub;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CoursePubDao extends JpaRepository<CoursePub,String> {
}
