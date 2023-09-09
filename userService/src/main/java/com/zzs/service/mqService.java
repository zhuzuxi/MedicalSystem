package com.zzs.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class mqService {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(){
        rabbitTemplate.convertAndSend("queue","it is userService");
    }
}
