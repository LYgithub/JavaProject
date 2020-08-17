package com.kawyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author LiYang
 * @Project Name: Spring-Boot-Security
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/30.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
public class Handler {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
