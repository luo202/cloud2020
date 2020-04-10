package com.lsx.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(RurekaMain7002.class,args);
    }
}
