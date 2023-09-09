package com.zzs.controller;

import com.zzs.Common.R;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class authController {
    @PostMapping
    public R<String> login(String username,String password){
        return null;


    }
}
