package com.woshiabao.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: jay
 * @time: 2021/12/9
 */
public interface PaymentService {

    public String paymentInfo_correct(Integer id);

    public String paymentInfo_error(Integer id);

    public String paymentCircuitBreaker(@PathVariable("id") Integer id);

}
