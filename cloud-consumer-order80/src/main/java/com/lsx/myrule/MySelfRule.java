package com.lsx.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    @Bean
    public IRule myTRule(){
        System.out.println("负载均衡随机规则");
        return new RandomRule();//定义为随机

    }
}
