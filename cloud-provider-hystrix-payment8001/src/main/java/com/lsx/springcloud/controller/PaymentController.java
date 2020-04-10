package com.lsx.springcloud.controller;

import com.lsx.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;
    //服务降级
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String result = paymentService.paymentInfo_ok(id);
        log.info("==result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        System.out.println("服务端controller"+serverport);
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("=======result:"+result);
        return result;
    }
    //服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCicruitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCiruitBreaker(id);
        log.info("******result:"+result);
        return result;
    }

}
