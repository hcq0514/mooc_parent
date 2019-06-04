package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.TeachPlanDao;
import com.mooc.course.service.TeachPlanService;
import com.mooc.model.course.Teachplan;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class TeachPlanServiceImpl extends ServiceImpl<TeachPlanDao, Teachplan> implements TeachPlanService {
}
