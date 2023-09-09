package com.zzs.Util;

import com.auth0.jwt.interfaces.Claim;
import com.zzs.Utill.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class testJWT {
    @Test
    public void testVerify(){
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsInBob25lIjoiMTMxMTk1NzE5MDQiLCJleHAiOjE2ODk1NDIxOTksImlhdCI6MTY4OTUyMDU5OX0.d0IY0f6fswgvGHoms_Ehz8Xh6cECM6PR0fjxEp1P5Kg";
        Map<String, Claim> map = JwtUtil.verifyToken(token);
        if (map==null){
            System.out.println("token无效");
        }
        System.out.println("token有效");
    }
}
