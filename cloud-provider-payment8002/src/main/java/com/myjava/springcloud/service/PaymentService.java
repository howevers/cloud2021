package com.myjava.springcloud.service;

import com.myjava.springcloud.entities.Payment;

public interface PaymentService {

    /**
     * 增
     * @param payment
     * @return
     */
    Integer create(Payment payment);


    /**
     * 查
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);
}
