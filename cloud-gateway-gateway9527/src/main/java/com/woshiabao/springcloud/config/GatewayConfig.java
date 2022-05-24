package com.woshiabao.springcloud.config;/**
 * @description:
 * @author: jay
 * @time: 2021/12/18
 */

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *@ClassName GatewayConfig
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Configuration
public class GatewayConfig {
    /**
    * @Description: 配置路由规则
    * @Param: builder
    * @return:
    * @Author: jay
    * @Date: 2021/12/18
    */
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_route_jjh",
                r -> r.path("/guoji")
                        .uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder)
    {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route_atguigu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();

        return routes.build();
    }

}
