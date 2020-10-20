package com.shiyanlou.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiYang
 * @Project Name: springboot
 * @Package Name: com.shiyanlou.controller
 * Created by MacBook Air on 2020/10/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
public class MyController {

    /** 使用value 注解注入属性值*/
    @Value("${yang.date}")
    String date ;

    @RequestMapping("/mycontroller")
    public String shiyanLou(){
        System.out.println("Hello World!" + date);
        return "HelloWorld!";
    }
}
