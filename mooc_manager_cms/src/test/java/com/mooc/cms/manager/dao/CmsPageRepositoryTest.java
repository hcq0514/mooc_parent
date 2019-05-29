package com.mooc.cms.manager.dao;

import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.model.GridFSFile;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsPageParam;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    GridFSBucket gridFSBucket;

    @Autowired
    private TemplateEngine templateEngine;


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

    @Test
    public void testGridFs() throws FileNotFoundException {
//要存储的文件
        File file = new File("d:/index_banner.html");
//定义输入流
        FileInputStream inputStram = new FileInputStream(file);
//向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "轮播图测试文件01", "");
//得到文件ID
        String fileId = objectId.toString();
        System.out.println(file);
    }

    @Test
    public void queryFile() throws IOException {
        String fileId = "5cee32d8fe4a8950244416e8";
//根据id查询文件
        GridFSFile gridFSFile =
                gridFsTemplate.findOne(Query.query(Criteria.where("_id").is(fileId)));
//打开下载流对象
        if (gridFSFile!=null){
            // mongo-java-driver3.x以上的版本就变成了这种方式获取
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            // 获取Mongodb中文件的缓存输出流
            gridFSBucket.downloadToStream(gridFSFile.getId(), baos);
            System.out.println(baos.toString());
        }
    }


    public void genHtmlPage() {
        Context context = new Context();
        context.setVariable("name", "列表数据");
        templateEngine.process("",context);
    }



}
