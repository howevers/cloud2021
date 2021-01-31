package com.myjava;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication      //启动类
@EnableEurekaClient     //服务注册发现
@EnableCircuitBreaker   //启用降级
public class ApplicationHystrix8001 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationHystrix8001.class,args);
    }
}
