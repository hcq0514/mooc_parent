package com.mooc.course.service.impl;

import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.course.dao.CourseMarketDao;
import com.mooc.course.service.CourseMarketService;
import com.mooc.model.cms.request.CmsQueryPageRequest;
import com.mooc.model.course.CourseMarket;
import com.mooc.model.errorCode.CourseErrorCode;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseMarketServiceImpl implements CourseMarketService {

    @Autowired
    CourseMarketDao courseMarketDao;

    @Override
    public QueryResponseResult findList(int page, int size, CmsQueryPageRequest cmsQueryPageRequest) {
        return null;
    }


    @Override
    public CourseMarket getById(String id) {
        Optional<CourseMarket> optionalCourseMarket = courseMarketDao.findById(id);
        return optionalCourseMarket.orElse(null);
    }

    @Override
    public CommonResult add(CourseMarket courseMarket) {
        CourseMarket save = courseMarketDao.save(courseMarket);
        return new CommonResult<>(CommonCode.SUCCESS, save);
    }

    @Override
    public CommonResult update(CourseMarket courseMarket) {
        CourseMarket update = courseMarketDao.save(courseMarket);
        return new CommonResult<>(CommonCode.SUCCESS, update);
    }

    @Override
    public CommonResult deleteById(String id) {
        Optional<CourseMarket> byId = courseMarketDao.findById(id);
        if (!byId.isPresent()) {
            ExceptionCast.cast(CourseErrorCode.COURSE_MARKET_NOT_EXIST);
        }
        courseMarketDao.deleteById(id);
        return new CommonResult<>(CommonCode.SUCCESS, null);
    }
}
