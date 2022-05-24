package com.woshiabao.springcloud.service;/**
 * @description:
 * @author: jay
 * @time: 2021/12/4
 */

import com.woshiabao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 *@ClassName PaymentService
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id")Long id);

}
