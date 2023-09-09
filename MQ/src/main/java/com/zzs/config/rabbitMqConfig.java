package com.zzs.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitMqConfig {
    @Bean
    public Queue queue(){
        return new Queue("queue");
    }
}
