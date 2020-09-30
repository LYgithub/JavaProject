package com.kawyang.controller;

import com.kawyang.entity.User;
import com.kawyang.entity.UserList;
import com.kawyang.entity.UserMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
//@Controller
@RestController
//对每个方法的ResponseBody 注解的优化
@RequestMapping("/data")
public class DataHandler {
    @RequestMapping("/data")
    @ResponseBody
    public String data(int id){
        return id+"";
    }


    @RequestMapping("/data2")
    @ResponseBody
    public String data(Integer id){
        return id+"";
    }

    @RequestMapping("/data3")
    @ResponseBody
    public String data3(@RequestParam(value = "num",required = false, defaultValue = "0") Integer id){
        return id+"";
    }

    @RequestMapping("/array")
    public String array(Integer [] id){
        return Arrays.toString(id);
    }

    @RequestMapping("/list")
    public String list(UserList users){
//        response.setContentType("text/html;charset=UTF-8");



//        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (User s :users.getUsers()) {
//            str += s;

            stringBuffer.append(s);
        }
//        return str;
        return stringBuffer.toString();
    }


    @RequestMapping("/map")
    public String map(UserMap map){
        StringBuffer buffer = new StringBuffer();
        for (java.lang.String key:map.getUsers().keySet()){
            User user = map.getUsers().get(key);
            buffer.append("[" + key + ":" );
            buffer.append(user+"]");
        }
        return buffer.toString();
    }

    @RequestMapping("/json")
    // RequestBody 前端json
    public User json(@RequestBody  User user){
        System.out.println(user);
        user.setId(3);
        return user;
    }
}
