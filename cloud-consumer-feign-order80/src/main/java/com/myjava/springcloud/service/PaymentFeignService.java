package com.myjava.springcloud.service;


import com.myjava.springcloud.entities.CommonResult;
import com.myjava.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")       //这个接口访问的是哪个服务
public interface PaymentFeignService {


    /**
     * 测试超时
     *
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

    /**
     * 增
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    CommonResult<Payment> create(@RequestBody Payment payment);


    /**
     * 查
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
