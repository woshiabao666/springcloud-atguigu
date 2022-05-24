package com.woshiabao.springcloud; /**
 * @description:
 * @author: jay
 * @time: 2021/12/21
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *@ClassName com.woshiabao.springcloud.ConfigCenterMain3344
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
