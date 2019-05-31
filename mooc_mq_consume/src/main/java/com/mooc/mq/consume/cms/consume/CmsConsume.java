package com.mooc.mq.consume.cms.consume;

import com.mooc.common.mq.RabbitMQCode;
import com.mooc.model.cms.CmsPage;
import com.mooc.model.cms.CmsSite;
import com.mooc.model.cms.response.CmsPageResult;
import com.mooc.mq.consume.cms.client.CmsPageClient;
import com.mooc.mq.consume.cms.client.CmsSiteClient;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Map;

/**
 * @author hcq
 */
@Component
public class CmsConsume {

    @Autowired
    CmsPageClient cmsPageClient;

    @Autowired
    CmsSiteClient cmsSiteClient;


    /**
     * 页面发布
     *
     * @param map
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitMQCode.MANAGER_CMS_PUBLISH_PAGE_QUEUE, durable = "true"),
            exchange = @Exchange(
                    value = RabbitMQCode.MANAGER_CMS_PUBLISH_PAGE_EXCHANGE,
                    ignoreDeclarationExceptions = "true"
            ),
            key = RabbitMQCode.MANAGER_CMS_PUBLISH_PAGE_ROUTING_KEY
    ))
    public void sendVerificationCode(Map map) {
        String pageId = (String) map.get("pageId");
        CmsPage cmsPage = cmsPageClient.getById(pageId);
        //页面物理路径
        String pagePath = cmsPage.getPagePhysicalPath() +
                cmsPage.getPageName();
        String htmlFileId = cmsPage.getHtmlFileId();
        //todo 从gridfs里面获取数据，然后写到那个物理路径
        System.out.println(cmsPage.getPageName());
    }
}
