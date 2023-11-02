package com.zzs.controller;

import com.zzs.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {
    @GetMapping("/hello")
    public R<String> hello(){
        return R.success("200","hello");
    }


}
