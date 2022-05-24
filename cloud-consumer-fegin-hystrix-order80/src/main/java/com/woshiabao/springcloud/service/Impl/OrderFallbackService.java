package com.woshiabao.springcloud.service.Impl;/**
 * @description:
 * @author: jay
 * @time: 2021/12/13
 */

import com.woshiabao.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

/**
 *@ClassName OrderFallbackService
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Component
public class OrderFallbackService implements OrderHystrixService {
    @Override
    public String paymentInfo_correct(Integer id) {
        return "PaymentFallbackService fallback paymentInfo_correct ~~(；′⌒`)~~";
    }

    @Override
    public String paymentInfo_error(Integer id) {
        return "PaymentFallbackService fallback paymentInfo_error ~~(；′⌒`)~~";
    }
}
