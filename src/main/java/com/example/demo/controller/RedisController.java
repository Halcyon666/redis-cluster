package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WhaleFall541
 * @Date: 2021/9/4 19:44
 */
@RestController
public class RedisController {
    private static int cnt = 0;
    private static Object object = new Object();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/get")
    public String get(String key) {
        Boolean flag = redisTemplate.opsForValue().setIfAbsent("lock", "lock");
        if (!flag) return "error";
        try {
            cnt++;
            System.out.println("get " + key + "第" + cnt + "次");
        }finally {
            redisTemplate.delete("lock");
        }
        return redisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/put")
    public void put(String key) {
        redisTemplate.opsForValue().set(key, key);
    }

}
