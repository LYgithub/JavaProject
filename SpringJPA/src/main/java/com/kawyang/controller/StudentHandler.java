package com.kawyang.controller;

import com.kawyang.entity.Student;
import com.kawyang.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author LiYang
 * @Project Name: SpringJPA
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
@RequestMapping("/jpa")
public class StudentHandler {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public Optional<Student> findById(@PathVariable long id){
        return studentRepository.findById(id);
    }

    @GetMapping("/getById/{id}")
    public Student getById(@PathVariable long id){
        return studentRepository.getById(id);
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @GetMapping("/deleteById/{id}")
    public void deleteById(@PathVariable long id){
        studentRepository.deleteById(id);
    }

}
