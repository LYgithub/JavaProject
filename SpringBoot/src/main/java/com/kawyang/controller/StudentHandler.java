package com.kawyang.controller;

import com.kawyang.entity.Student;
import com.kawyang.repository.Impl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/student")
public class StudentHandler {

    @Autowired
    private StudentRepositoryImpl studentRepository;

    @RequestMapping("/findAll")
    public Collection<Student> findAll(){
        return studentRepository.findAll();
    }



    @RequestMapping("/findById/{id}")
    public String findById(@PathVariable long id){
        return studentRepository.findById(id).toString();
    }


    @RequestMapping("/deleteById/{id}")
    public Collection<Student> deleteById(@PathVariable long id){
        studentRepository.deleteById(id);
        return findAll();
    }


    @RequestMapping("/save")
    public Collection<Student> save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
        return findAll();
    }


    @RequestMapping("/index")
    public String index(Model model){
        List<Student> list = new ArrayList<Student>(studentRepository.findAll());
        model.addAttribute("students", list);
        return "index";
    }

}
