package com.mooc.cms.manager.dao;

import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsPageParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Test
    public void testFindPage() {
        int page = 0;//从0开始
        int size = 10;//每页记录数
        Pageable pageable = PageRequest.of(page, size);
        Page<CmsPage> all = cmsPageRepository.findAll(pageable);
        System.out.println(all);
    }

    //添加
    @Test
    public void testInsert() {
//定义实体类
        CmsPage cmsPage = new CmsPage();
        cmsPage.setSiteId("s01");
        cmsPage.setTemplateId("t01");
        cmsPage.setPageName("测试页面");
        cmsPage.setPageCreateTime(new Date());
        List<CmsPageParam> cmsPageParams = new ArrayList<>();
        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value1");
        cmsPageParams.add(cmsPageParam);
        cmsPage.setPageParams(cmsPageParams);
        cmsPageRepository.save(cmsPage);
        System.out.println(cmsPage);
    }

    @Test
    public void testModify() {
        Optional<CmsPage> byId = cmsPageRepository.findById("5ce7af95fe4a892d085e5fb9");
        if (byId.isPresent()) {
            byId.get().setPageName("hhhhhhhhhhhhhhhh");
            cmsPageRepository.save(byId.get());
        }
    }

    @Test
    public void testJpa() {
        Pageable pageable = PageRequest.of(1, 1);
        Page<CmsPage> byPageAliase = cmsPageRepository.findByPageAliaseLikeAndSiteId("课","5a751fab6abb5044e0d19ea1", pageable);
        System.out.println(byPageAliase);
    }

    @Test
    public void testFindAll() {
//条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
//        exampleMatcher = exampleMatcher.withMatcher("pageAliase",
//                ExampleMatcher.GenericPropertyMatchers.contains());
//页面别名模糊查询，需要自定义字符串的匹配器实现模糊查询
//ExampleMatcher.GenericPropertyMatchers.contains() 包含
//ExampleMatcher.GenericPropertyMatchers.startsWith()//开头匹配
//条件值
        CmsPage cmsPage = new CmsPage();
//站点ID
//        cmsPage.setSiteId("5a751fab6abb5044e0d19ea1");
//模板ID
//        cmsPage.setTemplateId("5a962c16b00ffc514038fafd");
//        cmsPage.setPageAliase("分类导航");
//创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
        Pageable pageable =  PageRequest.of(0, 10);
        Page<CmsPage> all = cmsPageRepository.findAll(example, pageable);
        System.out.println(all);
    }


}