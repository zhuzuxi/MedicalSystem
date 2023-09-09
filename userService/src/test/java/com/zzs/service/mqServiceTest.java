package com.zzs.service;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class mqServiceTest {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Test
    public void sendMessage() throws InterruptedException {
        int i=0;
        while (i<50) {
            rabbitTemplate.convertAndSend("myqueue", "it is userService");
            Thread.sleep(2);
            i++;
        }
    }
}
