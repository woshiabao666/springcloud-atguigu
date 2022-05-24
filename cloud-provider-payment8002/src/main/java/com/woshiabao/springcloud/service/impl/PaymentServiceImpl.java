package com.woshiabao.springcloud.service.impl;/**
 * @description:
 * @author: jay
 * @time: 2021/12/4
 */

import com.woshiabao.springcloud.dao.PaymentDao;
import com.woshiabao.springcloud.entities.Payment;
import com.woshiabao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@ClassName PaymentServiceImpl
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
