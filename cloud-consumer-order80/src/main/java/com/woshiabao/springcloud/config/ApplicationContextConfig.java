package com.woshiabao.springcloud.config;/**
 * @description:
 * @author: jay
 * @time: 2021/11/28
 */

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *@ClassName ApplicationContextConfig
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
