package com.woshiabao.springcloud;/**
 * @description:
 * @author: jay
 * @time: 2021/12/15
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *@ClassName HystrixDashboardMain9001
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
