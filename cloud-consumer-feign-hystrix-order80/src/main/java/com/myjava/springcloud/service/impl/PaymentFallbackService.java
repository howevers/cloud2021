package com.myjava.springcloud.service.impl;

import com.myjava.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;


/**
 * 实现降级方法（只有降级时才执行）
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
    }
}
