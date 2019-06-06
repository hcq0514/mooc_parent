package com.mooc.course.service.impl;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.course.service.CourseMarketService;
import com.mooc.model.cms.request.CmsQueryPageRequest;
import com.mooc.model.course.CourseBase;
import com.mooc.model.course.CourseMarket;
import com.mooc.model.result.CommonResult;
import org.springframework.stereotype.Service;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseMarketServiceImpl implements CourseMarketService {

    @Override
    public QueryResponseResult findList(int page, int size, CmsQueryPageRequest cmsQueryPageRequest) {
        return null;
    }

    @Override
    public CourseBase getById(String id) {
        return null;
    }

    @Override
    public CommonResult add(CourseMarket courseMarket) {
        return null;
    }

    @Override
    public CommonResult update(CourseMarket courseMarket) {
        return null;
    }

    @Override
    public CommonResult deleteById(String id) {
        return null;
    }
}
