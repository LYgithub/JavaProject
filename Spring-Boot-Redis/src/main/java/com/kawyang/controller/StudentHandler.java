package com.kawyang.controller;

import com.kawyang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiYang
 * @Project Name: Spring-Boot-Redis
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/30.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
@RequestMapping("/redis")
public class StudentHandler {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/set")
    public void get(@RequestBody Student student){
        redisTemplate.opsForValue().set("stu", student);
    }

    @GetMapping("/get/{key}")
    public Student get(@PathVariable String key){
        return (Student) redisTemplate.opsForValue().get(key);
    }

    @GetMapping("/delete/{key}")
    public boolean delete(@PathVariable String key){
        redisTemplate.delete(key);
        return redisTemplate.hasKey(key);
    }


}
