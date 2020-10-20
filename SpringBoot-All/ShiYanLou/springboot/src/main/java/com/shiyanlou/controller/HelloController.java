package com.shiyanlou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author LiYang
 * @Project Name: springboot
 * @Package Name: com.shiyanlou.config
 * Created by MacBook Air on 2020/10/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
//注意这里已经不是 @RestController 了和上个试验不同，因为需要返回视图，所以不能使用 @ResponseBody
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "Hello";
    }
}
