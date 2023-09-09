package com.zzs.service;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
public class ThreadPoolTest {
    @Resource
    private RabbitTemplate RabbitTemplate;


    @Test
    public void test() throws InterruptedException {

        synchronized (this) {
            BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
            ThreadPoolExecutor threadPool = new ThreadPoolExecutor(17, 32, 2, TimeUnit.SECONDS, workQueue);
            for (int i = 0; i < 16; i++) {
                threadPool.execute(() -> {
                    Object o = null;
                    while (true) {
                        o = RabbitTemplate.receiveAndConvert("myqueue");
                        System.out.println("线程");
                    }
                });
            }
            wait();
        }

    }
}




