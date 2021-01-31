package com.myjava.springcloud.service.impl;

import com.myjava.springcloud.dao.PaymentDao;
import com.myjava.springcloud.entities.Payment;
import com.myjava.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Transactional
@Service
public class PaymentServiceImpl implements PaymentService {


    //@Autowired   Spring提供  先找Type在找name
    @Resource   //jdk提供 先找name在找Type
    PaymentDao paymentDao;

    /**
     * 增
     * @param payment
     * @return
     */
    @Override
    public Integer create(Payment payment) {
        return paymentDao.create(payment);
    }

    /**
     * 查
     * @param id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
