package com.mooc.course.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.request.CmsQueryPageRequest;
import com.mooc.model.course.CourseBase;
import com.mooc.model.course.CourseMarket;
import com.mooc.model.result.CommonResult;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
public interface CourseMarketService {
    QueryResponseResult findList(int page, int size, CmsQueryPageRequest cmsQueryPageRequest);

    CourseMarket getById(String id);

    CommonResult add(CourseMarket courseMarket);

    CommonResult  update(CourseMarket courseMarket);

    CommonResult  deleteById(String id);
}
