package com.zzs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class userService {

    @Resource
    private com.zzs.feign.doctorFeignClient doctorFeignClient;

    @GetMapping("/welcome")
    public String getWelcome(){
        return doctorFeignClient.welcome();
    }
}
