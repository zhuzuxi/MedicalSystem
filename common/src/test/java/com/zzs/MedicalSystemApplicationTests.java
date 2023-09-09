package com.zzs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class MedicalSystemApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private Jedis jedis;
    @Test
    void testRedis(){
        jedis.setex("lang",10,"java");
        System.out.println(jedis.get("lang"));

    }

}
