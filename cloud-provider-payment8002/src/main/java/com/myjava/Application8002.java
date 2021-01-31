package com.myjava;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.myjava.springcloud.dao")   //扫描dao层
@EnableTransactionManagement    //事务
@EnableEurekaClient    //在注册中心注册成为服务提供者
public class Application8002 {
    public static void main(String[] args) {
        SpringApplication.run(Application8002.class, args);
    }
}
