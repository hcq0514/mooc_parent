package com.mooc.course.service;

import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.model.cms.request.CmsQueryPageRequest;
import com.mooc.model.course.CourseBase;
import com.mooc.model.course.CoursePre;
import com.mooc.model.result.CommonResult;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
public interface CoursePreService {
    QueryResponseResult findList(int page, int size, CmsQueryPageRequest cmsQueryPageRequest);

    CourseBase getById(String id);

    CommonResult add(CoursePre coursePre);

    CommonResult  update(CoursePre coursePre);

    CommonResult  deleteById(String id);
}
