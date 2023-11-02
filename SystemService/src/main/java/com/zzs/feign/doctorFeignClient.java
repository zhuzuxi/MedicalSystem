package com.zzs.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "doctorService")
@Component
public interface doctorFeignClient {
    @GetMapping("doctor/gethello")
    public String welcome();
}
