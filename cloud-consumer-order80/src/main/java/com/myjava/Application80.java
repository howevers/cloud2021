package com.myjava;

import com.myRule.MySelRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient    //在注册中心注册成为服务消费者
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelRule.class)
public class Application80 {

    public static void main(String[] args) {
        SpringApplication.run(Application80.class,args);
    }
}
