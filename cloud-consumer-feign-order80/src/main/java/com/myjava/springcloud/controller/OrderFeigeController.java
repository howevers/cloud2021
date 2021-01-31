package com.myjava.springcloud.controller;

import com.myjava.springcloud.entities.CommonResult;
import com.myjava.springcloud.entities.Payment;
import com.myjava.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderFeigeController {


    @Autowired
    PaymentFeignService paymentFeignService;


    /**
     * 测试超时
     *
     * @return
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout() {
        return paymentFeignService.paymentFeignTimeout();
    }

    /**
     * 增
     * @param payment
     * @return
     */
    @PostMapping("/consumer/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }


    /**
     * 查
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
