package com.woshiabao.springcloud.controller;
/**
 * @description:
 * @author: jay
 * @time: 2021/11/25
 */
import com.woshiabao.springcloud.entities.CommentResult;
import com.woshiabao.springcloud.entities.Payment;
import com.woshiabao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.client.discovery.DiscoveryClient;


import javax.annotation.Resource;
import java.util.List;

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
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/payment/create")
    public CommentResult<Payment> create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("==========插入结果：" + result);
        if (result > 0){
            return new CommentResult(200,"插入数据成功,serverPort: " + serverPort,result);
        }else {
            return new CommentResult(500,"插入数据失败,serverPort: " + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/search/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = paymentService.getPaymentById(id);
        log.info("==========查询结果：" + payment);
        if (null != payment){
            return new CommentResult(200,"查询数据成功,serverPort: " + serverPort,payment);
        }else {
            return new CommentResult(500,"查询数据失败,serverPort: " + serverPort,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("******element:" + element);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }

        return this.discoveryClient ;

    }

    @GetMapping("/payment/lb")
    public String loadBalance(){
        return "8001";
    }


}
