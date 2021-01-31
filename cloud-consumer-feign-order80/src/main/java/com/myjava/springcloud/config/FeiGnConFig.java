package com.myjava.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeiGnConFig {

    @Bean
    public Logger.Level feiGnLevel(){
        return Logger.Level.FULL;
    }
}
