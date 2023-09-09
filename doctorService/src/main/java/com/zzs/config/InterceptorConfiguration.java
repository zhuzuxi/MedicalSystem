package com.zzs.config;

import com.zzs.Interceptor.PermissionInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PermissionInterceptor())
                .addPathPatterns("/doctor/**").excludePathPatterns("/doctor/login","/doctor/logout");
//                .addPathPatterns("")

    }
}
