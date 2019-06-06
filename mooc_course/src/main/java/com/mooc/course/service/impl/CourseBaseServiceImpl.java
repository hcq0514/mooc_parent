package com.mooc.course.service.impl;

import com.mooc.common.exception.ExceptionCast;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.course.dao.CourseBaseDao;
import com.mooc.course.service.CourseBaseService;
import com.mooc.model.cms.request.CmsQueryPageRequest;
import com.mooc.model.course.CourseBase;
import com.mooc.model.errorCode.CmsErrorCode;
import com.mooc.model.result.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseBaseServiceImpl implements CourseBaseService {


    @Autowired
    CourseBaseDao courseBaseDao;

    /**
     * 页面列表分页查询
     *
     * @param page             当前页码
     * @param size             页面显示个数
     * @param cmsQueryPageRequest 查询条件
     * @return 页面列表
     */
    @Override
    public QueryResponseResult findList(int page, int size, CmsQueryPageRequest cmsQueryPageRequest) {
        //页码
        page = page - 1;
        //分页对象
        Pageable pageable = PageRequest.of(page, size);
        //分页查询
        Page<CourseBase> all = courseBaseDao.findAll(pageable);
        //返回结果
        return new QueryResponseResult(CommonCode.SUCCESS,all);
    }

    @Override
    public CourseBase getById(String id) {
        Optional<CourseBase> optional = courseBaseDao.findById(id);
        boolean present = optional.isPresent();
        if (present) {
            return optional.get();
        }
        return null;
    }


    @Override
    public CommonResult add(CourseBase courseBase) {
        CourseBase base = courseBaseDao.save(courseBase);
        return new CommonResult<>(CommonCode.SUCCESS, base);
    }

    @Override
    public CommonResult update(CourseBase courseBase) {
        Optional<CourseBase> optionCourseBase = courseBaseDao.findById(courseBase.getId());
        if (!optionCourseBase.isPresent()) {
            ExceptionCast.cast(CmsErrorCode.CMS_PAGE_NOT_EXIST);
        }
        CourseBase update = courseBaseDao.save(courseBase);
        return new CommonResult<>(CommonCode.SUCCESS, update);
    }

    @Override
    public CommonResult deleteById(String pageId) {
        Optional<CourseBase> courseBase = courseBaseDao.findById(pageId);
        if (!courseBase.isPresent()) {
            ExceptionCast.cast(CmsErrorCode.CMS_PAGE_NOT_EXIST);
        }
        courseBaseDao.deleteById(pageId);
        return new CommonResult<>(CommonCode.SUCCESS, null);
    }
}
