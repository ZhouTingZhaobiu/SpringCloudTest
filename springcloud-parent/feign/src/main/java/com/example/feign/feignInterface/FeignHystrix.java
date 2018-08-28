package com.example.feign.feignInterface;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrix implements HandleFeignInterface {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+ name;
    }
}
