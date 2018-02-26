package com.demo.service;

import com.demo.model.Comunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class redis {

    @Autowired
    private RedisTemplate redisTemplate;


    public void setData(Comunity com){
        ValueOperations<String, Object> valueOperations = redisTemplate
                .opsForValue();
        // 设置value为对象类型，设置过期时间为80秒，时间单位由TimeUnit控制
        valueOperations.set("2", com, 80, TimeUnit.SECONDS);
    }

/*    public String getData(String key){
        ValueOperations<String, Object> valueOperations = redisTemplate
                .opsForValue();
        Comunity com1 = (Comunity) valueOperations.get(key);
        return com1.getCity();
    }*/
}
