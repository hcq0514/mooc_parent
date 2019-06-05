package com.mooc.course.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mooc.model.course.Category;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
public interface CourseCategoryService extends IService<Category> {
    Category buildCategoryNode();
}
