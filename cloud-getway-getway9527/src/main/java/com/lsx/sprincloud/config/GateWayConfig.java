package com.lsx.sprincloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lsx",
                r->r.path("/guonei")
                        .uri("https://news.baidu.com/guonei"));
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator2(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lsx",
                r->r.path("/guoji")
                        .uri("https://news.baidu.com/guoji"));
        return routes.build();
    }
    @Bean
    public RouteLocator customRouteLocator3(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lsx",
                r->r.path("/mil")
                        .uri("https://news.baidu.com/mil"));
        return routes.build();
    }
}
