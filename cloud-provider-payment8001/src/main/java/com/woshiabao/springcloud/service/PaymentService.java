package com.woshiabao.springcloud.service;

import com.woshiabao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @description:
 * @author: jay
 * @time: 2021/11/25
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
