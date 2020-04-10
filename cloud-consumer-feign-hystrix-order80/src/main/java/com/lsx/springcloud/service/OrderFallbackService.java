package com.lsx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderFallbackService implements OrderHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----OrderFallbackService fallback  paymentInfo_ok";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----OrderFallbackService fallback  paymentInfo_Timeout";
    }
}
