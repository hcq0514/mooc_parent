package com.mooc.course.dao;

import com.mooc.model.course.CourseMarket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

public interface CourseMarketDao extends JpaRepository<CourseMarket,String> {
}
