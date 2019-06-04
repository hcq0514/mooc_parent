package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.CoursePreDao;
import com.mooc.course.service.CoursePreService;
import com.mooc.model.course.CoursePre;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CoursePreServiceImpl extends ServiceImpl<CoursePreDao, CoursePre> implements CoursePreService {
}
