package com.woshiabao.springcloud;/**
 * @description:
 * @author: jay
 * @time: 2021/12/4
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@ClassName Payment8002
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class,args);
    }
}
