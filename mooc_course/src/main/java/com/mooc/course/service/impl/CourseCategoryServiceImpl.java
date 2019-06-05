package com.mooc.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mooc.course.dao.CourseCategoryDao;
import com.mooc.course.service.CourseCategoryService;
import com.mooc.model.course.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : hcq
 * @date : 2019/6/4
 */
@Service
public class CourseCategoryServiceImpl extends ServiceImpl<CourseCategoryDao, Category> implements CourseCategoryService {

    @Autowired
    CourseCategoryDao courseCategoryDao;

    @Override
    public Category buildCategoryNode() {
        Category query = new Category();
        query.setParentid("0");
        Category category = courseCategoryDao.selectOne(new QueryWrapper<>(query));
        return this.findChildren(category);
    }

    private Category findChildren(Category parentCategory) {

        if (parentCategory.getIsleaf() == 0) {
            //获取子节点
            List<Category> categoryNodes = courseCategoryDao.selectChildren(parentCategory.getId());
            parentCategory.setChildren(categoryNodes);
            for (Category c : categoryNodes) {
                findChildren(c);
            }
        }
        return parentCategory;
    }


}
