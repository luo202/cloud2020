package com.lsx.springcloud.controller;

import com.lsx.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_ok(id);
        return result;
    }

    @GetMapping("/consumer/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
//    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_Timeout(id);
        return "消费者："+result;
    }
    public String paymentInfo_TimeoutHandler(Integer id){
        return "我是消费者，支付系统忙，请稍后再试,id"+id+"\t"+"难过(ಥ﹏ಥ)";
    }
    //下面是全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后再试，(ಥ﹏ಥ)";
    }
}
