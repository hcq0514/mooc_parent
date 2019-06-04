package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.CourseBaseDao;
import com.mooc.course.service.CourseBaseService;
import com.mooc.model.course.CourseBase;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseBaseServiceImpl extends ServiceImpl<CourseBaseDao, CourseBase> implements CourseBaseService {
}
