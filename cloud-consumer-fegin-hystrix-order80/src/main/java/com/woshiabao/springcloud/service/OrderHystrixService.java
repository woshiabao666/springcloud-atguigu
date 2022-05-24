package com.woshiabao.springcloud.service;

import com.woshiabao.springcloud.entities.CommentResult;
import com.woshiabao.springcloud.entities.Payment;
import com.woshiabao.springcloud.service.Impl.OrderFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: jay
 * @time: 2021/12/12
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallbackService.class)
public interface OrderHystrixService {

    @GetMapping("/payment/hystrix/correct/{id}")
    public String paymentInfo_correct(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/error/{id}")
    public String paymentInfo_error(@PathVariable("id") Integer id);
}
