package com.kawyang.controller;

import com.kawyang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/25.
 * Copyright © 2020 LiYang. All rights reserved.
 *IoC管理 相当于配置 xml
Controller较 @Component添加了控制器的功能
 */
@Controller
//区分多个index
@RequestMapping(value = "/hello",method = RequestMethod.GET)
public class HelloHandler {
    /** 关联连接*/
    @RequestMapping("/index")
    public String index(){
        System.out.println("执行了index....");
        return "index";
    }

    public String index(@RequestParam("name") String str, @RequestParam("id") int age){
        return "index";
    }

    @RequestMapping("/index/{name}/{id}")
    public String index2(@PathVariable("name") String str, @PathVariable("id") int age){
        return "index";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue(value = "JSESSIONID") String sessionid){
        System.out.println(sessionid);
        return "index";
    }

    @RequestMapping("/save")
    public String save(User user){
        System.out.println(user);
        return "index";
    }



    @RequestMapping("/forward")
    public String forward(){
        return "forward:http://www.baidu.com";
//        return "index";
    }


    @RequestMapping("/redirect")
    public String redirect(){
        return "redirect:http://www.baidu.com";
    }
}
