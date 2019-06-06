package com.mooc.course.service.impl;

import com.mooc.course.dao.CourseCategoryDao;
import com.mooc.course.service.CourseCategoryService;
import com.mooc.model.course.CourseCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseCategoryServiceImpl  implements CourseCategoryService {

    @Autowired
    CourseCategoryDao courseCategoryDao;

    @Override
    public CourseCategory buildCategoryNode() {
        CourseCategory courseCategory = courseCategoryDao.findByParentid("0").get(0);
        return this.findChildren(courseCategory);
    }

    private CourseCategory findChildren(CourseCategory parentCourseCategory) {

        if (parentCourseCategory.getIsleaf() == 0) {
            //获取子节点
            List<CourseCategory> courseCategoryNodes = courseCategoryDao.findByParentid(parentCourseCategory.getId());
            parentCourseCategory.setChildren(courseCategoryNodes);
            for (CourseCategory c : courseCategoryNodes) {
                findChildren(c);
            }
        }
        return parentCourseCategory;
    }

}
