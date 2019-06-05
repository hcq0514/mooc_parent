package com.mooc.course.test;

import com.mooc.course.service.CourseCategoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseServiceTest {

    @Autowired
    CourseCategoryService courseCategoryService;

    @Test
    public void testBuildChildren(){
        courseCategoryService.buildCategoryNode();
    }


}
