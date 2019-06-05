package com.mooc.course.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mooc.model.course.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */

@Mapper
public interface CourseCategoryDao extends BaseMapper<Category> {

    @Select("select *  from course_category where parentid  = #{id} ")
    List<Category> selectChildren(String id);
}
