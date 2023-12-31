package com.zzs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableAspectJAutoProxy
@EnableWebMvc
public class doctorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(doctorServiceApplication.class,args);
    }
}