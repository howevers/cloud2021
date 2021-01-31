package com.myjava.springcloud.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootConfiguration            //配置类注解
public class ApplicationContextConfig {


    @Bean       //指明这是个bean，会创建Bean对象交给Spring管理
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
