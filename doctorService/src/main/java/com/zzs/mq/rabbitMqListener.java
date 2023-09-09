package com.zzs.mq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class rabbitMqListener {
    @Resource
    private RabbitTemplate rabbitTemplate;




    @RabbitListener(queues = "myqueue")
    public void getMessage1(String message){
//        rabbitTemplate.receive("myqueue");
        System.out.println("消费者1"+message);


    }

    @RabbitListener(queues = "myqueue")
    public void getMessage2(String message) throws InterruptedException {
//        rabbitTemplate.receive("myqueue");
        System.out.println("消费者2"+message);
//        Thread.sleep(2);

    }

    @RabbitListener(queues = "myqueue")
    public void getMessage3(String message) throws InterruptedException {
//        rabbitTemplate.receive("myqueue");
        System.out.println("消费者3"+message);

    }




}
