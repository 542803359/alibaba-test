package com.xiaowenxing.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 *
 * @author XWX
 * @date 2021/9/15 16:52
 * @since 4.2
 **/
@Component
@Slf4j
public class CustomGlobalFilter implements GlobalFilter, Ordered {


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        MultiValueMap<String, String> queryParams = request.getQueryParams();

        log.info("info-path:{},queryParams:{}", request.getPath().toString(),queryParams);

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
