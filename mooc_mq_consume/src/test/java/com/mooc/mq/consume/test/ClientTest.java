package com.mooc.mq.consume.test;

import com.mooc.model.cms.CmsPage;
import com.mooc.mq.consume.cms.client.CmsPageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientTest {
    @Autowired
    CmsPageClient cmsPageClient;
    @Test
    public void testMq() {
        CmsPage sad = cmsPageClient.getById("5a795ac7dd573c04508f3a56");
        System.out.println();

    }


}
