package com.bbraun.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
/*
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes().route("service-producto", r -> r.path("/api/productos/**").uri("http://localhost:8080"))
                .route("service-lote", r -> r.path("/api/lotes/**").uri("http://localhost:8081"))
                .build();
    }

 */
}
