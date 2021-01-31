package com.myjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients     //启用openfeigen功能    用于远程调用 ，基于接口开发
public class ApplicationFeign80 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFeign80.class,args);
    }
}
