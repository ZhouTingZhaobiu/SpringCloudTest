package com.springcloud.miya;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class MiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiyaApplication.class, args);
    }

    private static final Logger LOGGER = Logger.getLogger(MiyaApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


    @RequestMapping("/info")
    public String home() {
        LOGGER.log(Level.INFO, "info trace miya  ");
        return "hi i'm miya";
    }

    @RequestMapping("/miya")
    public String callHome(){
        LOGGER.log(Level.INFO, "calling trace miya  ");
        return restTemplate.getForObject("http://localhost:8988/hib", String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
