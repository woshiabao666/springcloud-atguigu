package com.woshiabao.springcloud.controller;
/**
 * @description:
 * @author: jay
 * @time: 2021/11/28
 */

import com.woshiabao.springcloud.entities.CommentResult;
import com.woshiabao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *@ClassName OrderController
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommentResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create",payment,CommentResult.class);
    }

    @GetMapping("/consumer/payment/search/{id}")
    public CommentResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL + "/payment/search/" + id,CommentResult.class);
    }

    @GetMapping("/consumer/payment2/searchForEntity/{id}")
    public CommentResult<Payment> getPayment2(@PathVariable("id") Long id){
         ResponseEntity<CommentResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/search/" + id,CommentResult.class);
         if (entity.getStatusCode().is2xxSuccessful()){
             return entity.getBody();
         }else {
             return new CommentResult<>(404,"操作失败");
         }
    }

}
