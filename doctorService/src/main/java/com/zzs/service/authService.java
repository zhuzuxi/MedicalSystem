package com.zzs.service;

import org.springframework.stereotype.Service;

@Service
public interface authService {
    public String login(String username, String password);

}
