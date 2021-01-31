package com.myjava.springcloud.service;

public interface PaymentService {

    //成功
    String paymentInfo_OK(Integer id);

    //超时
    String paymentInfo_Timeout(Integer id);
}
