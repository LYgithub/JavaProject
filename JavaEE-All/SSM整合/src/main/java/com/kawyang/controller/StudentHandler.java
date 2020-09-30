package com.kawyang.controller;

import com.kawyang.entity.Student;
import com.kawyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiYang
 * @Project Name: SSM整合
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/07/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/get")
public class StudentHandler {

    @Autowired
    private UserService userService;

    @RequestMapping("/student/{id}")
    public ModelAndView findById(@PathVariable int id){
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("student",userService.findById(id));
        return modelAndView;
    }
}
