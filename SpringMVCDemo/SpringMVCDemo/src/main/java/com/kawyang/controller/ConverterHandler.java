package com.kawyang.controller;

import com.kawyang.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
@RequestMapping("/converter")
public class ConverterHandler {

    @RequestMapping("/data")
    public String date(Date date){
        return date.toString();
    }

    @RequestMapping("/student")
    public String student(Student student){
        return student.toString();
    }
}
