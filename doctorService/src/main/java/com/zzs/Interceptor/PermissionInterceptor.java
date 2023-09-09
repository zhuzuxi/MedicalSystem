package com.zzs.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.zzs.Common.Constant.DELAY_EXPIRATION;
import static com.zzs.Common.Constant.DOCTOR_TOKEN_PRE;

@Configuration
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    private Jedis jedis;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        判断 header带的token 是否存在于redis 存在则放行 且增加redis中token的时长
        String token = request.getHeader("token");
        if (jedis.exists(DOCTOR_TOKEN_PRE+token) && token!=null){
            jedis.expire(token, Math.toIntExact(DELAY_EXPIRATION));
            return true;
        }

        return false;
    }
}
