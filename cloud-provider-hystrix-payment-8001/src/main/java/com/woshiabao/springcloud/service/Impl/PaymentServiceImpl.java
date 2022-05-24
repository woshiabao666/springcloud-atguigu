package com.woshiabao.springcloud.service.Impl;/**
 * @description:
 * @author: jay
 * @time: 2021/12/9
 */

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.woshiabao.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 *@ClassName PaymentServiceImpl
 *@Description 正常访问
 *@Author jay
 *@version 1.0.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentInfo_correct(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_correct,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "PaymentInfo_errorHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
    })
    public String paymentInfo_error(Integer id) {

        int timeNumber = 2;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (Exception e){
            e.printStackTrace();
        }

//        运行时异常
//        int i = 10/0;

        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_error,id: " + id + "\t" + "O(∩_∩)O哈哈~  总共耗时:" + timeNumber + "秒";
    }



    public String PaymentInfo_errorHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "PaymentInfo_errorHandler,id: " + id + "\t" + "(′⌒`)~~系统繁忙或出错,请稍后再试~~!";
    }


    //服务器熔断
    @Override
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id) {

        if (id < 0){
            throw new RuntimeException("**********id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()  + "\t 调用成功，流水号：" + serialNumber;
    }

    //降级方法
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

}
