package com.kawyang.controller;

import com.kawyang.entity.Student;
import com.kawyang.repository.impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author LiYang
 * @Project Name: SpringBootDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/spring")
@SuppressWarnings("all")
public class HelloHandler {

    @Autowired
    private StudentRepositoryImpl studentRepository;

    @RequestMapping("/hello")
    public String Hello(){
        System.out.println("index...");
        return "index";
    }

    @RequestMapping("/")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show");
        modelAndView.addObject("list", studentRepository.findAll());
        return modelAndView;
    }


    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable long id){
        studentRepository.deleteById(id);
        return "redirect:/spring/";
    }

    @GetMapping("/save/{id}")
    public ModelAndView save(@PathVariable long id){
        Student byId = studentRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("save");
        modelAndView.addObject("student", byId);
        return modelAndView;
    }


    @PostMapping("/save")
    public String save(Student student){
        studentRepository.saveOrUpdate(student);
        return "redirect:/spring/";
    }


}
