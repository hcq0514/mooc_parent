package com.cms.manager.service;

import com.cms.manager.dao.CmsPageRepository;
import com.mooc.common.model.response.CommonCode;
import com.mooc.common.model.response.QueryResponseResult;
import com.mooc.common.model.response.QueryResult;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.request.QueryPageRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {
    @Autowired
    CmsPageRepository cmsPageRepository;

    @Autowired
    MongoTemplate mongoTemplate;
    /**
     * 页面列表分页查询
     *
     * @param page             当前页码
     * @param size             页面显示个数
     * @param queryPageRequest 查询条件
     * @return 页面列表
     */
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
//条件匹配器
//页面名称模糊查询，需要自定义字符串的匹配器实现模糊查询
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("pageAliase", ExampleMatcher.GenericPropertyMatchers.contains());
//条件值
        CmsPage cmsPage = new CmsPage();
//站点ID
        if (StringUtils.isNotEmpty(queryPageRequest.getSiteId())) {
            cmsPage.setSiteId(queryPageRequest.getSiteId());
        }
//页面别名
        if (StringUtils.isNotEmpty(queryPageRequest.getPageAliase())) {
            cmsPage.setPageAliase(queryPageRequest.getPageAliase());
        }
//创建条件实例
        Example<CmsPage> example = Example.of(cmsPage, exampleMatcher);
//页码
        page = page - 1;
//分页对象
        Pageable pageable = PageRequest.of(page, size);
//分页查询
        Criteria criteria = Criteria.where("pageType").is("1")
                .andOperator(Criteria.where("pageAliase").regex("课")) ;
        Page<CmsPage> all = (Page<CmsPage>) mongoTemplate.find(new Query().addCriteria(criteria).with(pageable), CmsPage.class);
        QueryResult<CmsPage> cmsPageQueryResult = new QueryResult<>();
        cmsPageQueryResult.setList(all.getContent());
        cmsPageQueryResult.setTotal(all.getTotalElements());
//返回结果
        return new QueryResponseResult(CommonCode.SUCCESS, cmsPageQueryResult);
    }
}

