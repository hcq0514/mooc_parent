package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.CoursePubDao;
import com.mooc.course.service.CoursePubService;
import com.mooc.model.course.CoursePub;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CoursePubServiceImpl extends ServiceImpl<CoursePubDao, CoursePub> implements CoursePubService {
}
