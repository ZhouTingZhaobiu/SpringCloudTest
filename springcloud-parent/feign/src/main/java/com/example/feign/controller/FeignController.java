package com.example.feign.controller;


import com.example.feign.feignInterface.HandleFeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    HandleFeignInterface handleFeignInterface;

    @RequestMapping("/hi")
    public String hi(@RequestParam String name){
        return handleFeignInterface.sayHiFromClientOne(name);
    }
}
