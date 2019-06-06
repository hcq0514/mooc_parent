package com.mooc.course.test;

import com.mooc.course.dao.CourseCategoryDao;
import com.mooc.model.course.CourseCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {

//    @Autowired
//    CourseCategoryService courseCategoryService;
//
//    @Autowired
//    CourseBaseDao courseBaseDao;

    @Autowired
    CourseCategoryDao courseCategoryDao;

    @Test
    public void testBuildChildren(){
        List<CourseCategory> all = courseCategoryDao.findAll();
        System.out.println("all = " + all);
//        courseCategoryService.buildCategoryNode();
    }

    @Test
    public void testCourseBase()
    {
//        List<CourseBase> all = courseBaseDao.findAll();
//        System.out.println(all);
    }

}
