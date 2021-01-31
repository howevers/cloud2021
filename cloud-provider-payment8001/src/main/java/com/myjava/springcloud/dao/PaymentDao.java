package com.myjava.springcloud.dao;

import com.myjava.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentDao {

    /**
     * 新增
     * @param payment
     * @return
     */
    Integer create(Payment payment);


    /**
     * 根据id获取信息
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
