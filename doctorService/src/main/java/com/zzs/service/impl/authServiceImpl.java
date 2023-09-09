package com.zzs.service.impl;

import com.zzs.Utill.JwtUtil;
import com.zzs.service.authService;

public class authServiceImpl implements authService {
    @Override
    public String login(String username, String password) {

        String token = JwtUtil.createToken(username, password);
        return null;
    }
}
