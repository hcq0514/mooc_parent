package com.mooc.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "com.mooc.*")
@EntityScan("com.mooc.model.*")
@EnableSwagger2
public class CourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class);
    }


}
