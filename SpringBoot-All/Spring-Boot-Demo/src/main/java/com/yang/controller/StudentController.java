package com.yang.controller;

import com.yang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiYang
 * @Project Name: SpringBootStrat1
 * @Package Name: com.yang.controller
 * Created by MacBook Air on 2020/09/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("/find")
    public ModelAndView getStudent( ModelAndView modelAndView){
        System.out.println("hello");
        modelAndView.addObject("Student", studentService.findById(1));
        return modelAndView;
    }
}
