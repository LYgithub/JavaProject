package com.kawyang.controller;

import com.kawyang.entity.Student;
import com.kawyang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@RestController
@RequestMapping("/rest")
public class RESTHandler {

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/findAll")
    @GetMapping("/findAll")
    public Collection<Student> findAll(HttpServletResponse response){
        response.setContentType("text/json;charset=UTF-8");
        return studentRepository.findAll();
    }


    @GetMapping("/findById/{id}")
    public  Student findById(@PathVariable("id") long id){
        return studentRepository.findById(id);
    }

    @PostMapping(value = {"/save", "/update"})
    public void save(@RequestBody Student student){
        System.out.println("save");
        studentRepository.SaveOrUpdate(student);
    }

    @DeleteMapping("/delete/{id}")
    public void update(@PathVariable("id") long id){
        studentRepository.deleteById(id);
    }
}
