package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.CourseMarketDao;
import com.mooc.course.service.CourseMarketService;
import com.mooc.model.course.CourseMarket;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseMarketServiceImpl extends ServiceImpl<CourseMarketDao, CourseMarket> implements CourseMarketService {
}
