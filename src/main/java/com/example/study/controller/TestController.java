package com.example.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping
    public String peopleCount(){
       long value= stringRedisTemplate.opsForValue().increment("peopleCount",1);

        return "有"+value+"人访问了本页面！";
    }

}
