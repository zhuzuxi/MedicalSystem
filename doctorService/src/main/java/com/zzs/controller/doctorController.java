package com.zzs.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zzs.Common.R;
import com.zzs.Entity.Doctor;
import com.zzs.Utill.CommonUtils;
import com.zzs.annotation.JoinSentinel;
import com.zzs.service.IDoctorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.zzs.Common.Constant.DOCTOR_TOKEN_PRE;

@Api("DoctorController")
@RestController
@RequestMapping("/doctor")
public class doctorController {

    @SentinelResource("hello")
    @GetMapping("/gethello")
    public R<String> getHello(){
        return R.success("200","hello");
    }

    @SentinelResource("test")
    @GetMapping("/test")
    public R<String> test(){
        return R.success("200","test");
    }

    @Autowired
    private IDoctorService doctorService;

    @PostMapping("/login")
    public R login(HttpServletResponse response, @RequestBody Doctor doctor) throws IOException {
        R res = doctorService.login(doctor, response);
        if (res==null){
            return res;
        }
        return res;
    }
    @GetMapping("/logout")
    public R logout(HttpServletRequest request){
//        让前端 视图层进行操作
//        后端设置token为空即可
        String token = DOCTOR_TOKEN_PRE+request.getHeader("token");
        return  doctorService.logout(token);
    }

    @PostMapping()
    public R registry(@RequestBody Doctor doctor){
        if (StringUtils.isEmpty(doctor.getID())){
            doctor.setID(CommonUtils.UUIDBuild());
        }
        System.out.println(doctor);
        return doctorService.registry(doctor);
    }

    @PutMapping()
    public R update(@RequestBody Doctor doctor){
        return doctorService.update(doctor);
    }

}
