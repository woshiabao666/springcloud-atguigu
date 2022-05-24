package com.woshiabao.springcloud;/**
 * @description:
 * @author: jay
 * @time: 2021/12/18
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@ClassName GatewayMain9527
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class,args);
    }
}
