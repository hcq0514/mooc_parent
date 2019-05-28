package com.mooc.cms.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.mooc.*")
@EnableSwagger2
@EnableEurekaClient
public class CmsManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsManagerApplication.class);
    }

}
