package com.woshiabao;/**
 * @description:
 * @author: jay
 * @time: 2021/12/22
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *@ClassName ConfigClientMain3355
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
