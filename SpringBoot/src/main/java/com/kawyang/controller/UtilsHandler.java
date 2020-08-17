package com.kawyang.controller;

import com.kawyang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.expression.Fields;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/utils")
public class UtilsHandler {

    @RequestMapping("/date")
    public String tool(Model model, HttpServletRequest request){
        request.setAttribute("request", "request信息");
        request.getSession().setAttribute("session", "session信息");
        model.addAttribute("date", new Date());

        model.addAttribute("list", new ArrayList<Integer>());
        model.addAttribute("name", null);

        return "utils";
    }


    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("user", new User(1L,"string", 23));
        return "login";
    }

    @PostMapping("/form")
    public String form(@Valid User user, BindingResult result, Fields fields){
        System.out.println(user);
        System.out.println(fields.errors());
//        result
        if(result.hasErrors()){
            for (ObjectError obj: result.getAllErrors()) {
                System.out.println(obj.getCode() + "----" + obj.getDefaultMessage());
            }
        }
        return "login";
    }
}
