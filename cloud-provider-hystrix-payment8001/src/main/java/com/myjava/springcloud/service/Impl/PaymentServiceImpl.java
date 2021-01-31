package com.myjava.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.myjava.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;


@Service
public class PaymentServiceImpl implements PaymentService {


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    //成功
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() +
                "   paymentInfo_OK,id：  " + id + "\t" + "哈哈哈";
    }


    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    //超时
    @Override
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() +
                "   paymentInfo_TimeOut,id：  " + id + "\t" + "呜呜呜" + " 耗时(秒)" + timeNumber;
    }


    //兜底方法
    private String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() +
                " payment_TimeoutHandler,系统繁忙,请稍后再试\t o(╥﹏╥)o ";
    }


////////////////////////////////////////////////////////////////////////////////////////////////////////////


    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            //当在配置时间窗口内达到此数量的失败后，打开断路，默认20个
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            //断路多久以后开始尝试是否恢复，默认5s
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            //出错百分比阈值，当达到此阈值后，开始短路。默认50%
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public String paymentCircuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();//hutool.cn工具包

        return Thread.currentThread().getName() + "\t" + "调用成功,流水号：" + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " + id;
    }
}
