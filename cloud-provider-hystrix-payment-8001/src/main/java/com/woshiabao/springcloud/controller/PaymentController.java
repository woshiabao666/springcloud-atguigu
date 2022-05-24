package com.woshiabao.springcloud.controller;/**
 * @description:
 * @author: jay
 * @time: 2021/12/9
 */

import com.woshiabao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *@ClassName PaymentController
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/hystrix/correct/{id}")
    public String paymentInfo_correct(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_correct(id);
        log.info("**************result:"+ result +"*************");
        return result;
    }

    @GetMapping("/payment/hystrix/error/{id}")
    public String paymentInfo_error(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_error(id);
        log.info("**************result:"+ result +"*************");
        return result;
    }

    //服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*****result:" + result);
        return result;
    }

}
