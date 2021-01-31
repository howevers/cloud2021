package com.myRule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 这个类设置了负载均衡的规则
 */


@Configuration          //配置类
public class MySelRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();//随机规则
    }
}
