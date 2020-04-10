package com.lsx.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //appicationContext.xml  <bean id="" calss="">
    @Bean
    @LoadBalanced //使用注解加载负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
