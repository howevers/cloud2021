package com.myjava.springcloud.controller;


import com.myjava.springcloud.entities.CommonResult;
import com.myjava.springcloud.entities.Payment;
import com.myjava.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j   //日志相关的注解   使用log.    输出日志
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    //端口号
    @Value("${server.port}")
    String port;


    /**
     * 增
     *
     * @param payment
     * @return
     */
    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        Integer res = paymentService.create(payment);
        log.debug("结果：" + res);
        if (res > 0) {
            return new CommonResult(200, port + "插入数据成功", res);
        } else {
            return new CommonResult(444, port + "插入数据失败");
        }
    }


    /**
     * 查
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, port + "查询数据成功", payment);
        } else {
            return new CommonResult(444, port + "查询数据失败");
        }
    }
}
