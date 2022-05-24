package com.woshiabao.springcloud.controller;/**
 * @description:
 * @author: jay
 * @time: 2021/12/12
 */

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woshiabao.springcloud.service.OrderHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@ClassName PaymentHytrixService
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/correct/{id}")
    public String paymentInfo_correct(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_correct(id);
        return result;
    }

//    @HystrixCommand(fallbackMethod = "PaymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/error/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_error(id);
        return result;
    }

    public String PaymentInfo_TimeOutHandler(Integer id){
        return "线程池: "+ Thread.currentThread().getName() + " 支付模块繁忙,请稍后再试,(；′⌒`)";
    }

    //全局fallback
    public String payment_Global_FallbackMethod(){
        return "Global_error!!! please try again later~~(；′⌒`)~~";
    }
}
