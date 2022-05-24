package com.rule;/**
 * @description:
 * @author: jay
 * @time: 2021/12/5
 */

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName MyRule
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule(){
        return new RandomRule();//定义为随机
    }

}
