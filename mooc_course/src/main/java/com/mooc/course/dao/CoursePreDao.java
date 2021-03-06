package com.mooc.course.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooc.model.course.Category;
import com.mooc.model.course.CoursePre;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

@Mapper
public interface CoursePreDao extends BaseMapper<CoursePre> {
}
