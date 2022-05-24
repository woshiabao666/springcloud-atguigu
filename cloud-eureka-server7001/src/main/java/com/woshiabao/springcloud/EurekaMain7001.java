package com.woshiabao.springcloud;/**
 * @description:
 * @author: jay
 * @time: 2021/11/29
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *@ClassName EurekaMain7001
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
