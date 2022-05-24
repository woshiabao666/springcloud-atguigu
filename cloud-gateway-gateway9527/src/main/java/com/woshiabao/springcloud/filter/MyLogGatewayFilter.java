package com.woshiabao.springcloud.filter;/**
 * @description:
 * @author: jay
 * @time: 2021/12/19
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 *@ClassName MyLogGatewayFilter
 *@Description TODO
 *@Author jay
 *@version 1.0.0
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("==================== come into MyLogGatewayFilter:  " + new Date() + " ===================");

        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (null == username){
            log.info("===========用户名为空,非法用户~~(；′⌒`)~~");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
