package com.mooc.mq.consume.cms.consume;

import com.mooc.common.mq.RabbitMQCode;
import com.mooc.model.cms.response.CmsPageResult;
import com.mooc.mq.consume.cms.client.CmsPageClient;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hcq
 */
//@Component
public class CmsConsume {

    @Autowired
    CmsPageClient cmsPageClient;


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

        System.out.println(pageId);
    }
}
