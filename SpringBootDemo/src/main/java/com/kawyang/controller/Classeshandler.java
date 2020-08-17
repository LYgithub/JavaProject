package com.kawyang.controller;

import com.kawyang.entity.Classes;
import com.kawyang.entity.Student;
import com.kawyang.repository.impl.ClassesRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBootDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
@RequestMapping("/jdbc")
public class Classeshandler {
    @Autowired
    private ClassesRepositoryImpl classesRepository;


    @GetMapping("/findAll")
    public List<Classes> findAll(){
        return classesRepository.findAll();
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        return Integer.toString( classesRepository.deleteById(id));
    }

    @GetMapping("/findById/{id}")
    public String findById(@PathVariable int id){
        return classesRepository.findById(id).toString();
    }

    @PostMapping("/insert")
    public int insert(@RequestBody Classes classes){
        return classesRepository.save(classes);
    }

    @PostMapping("/update")
    public int update(@RequestBody Classes classes){
        return classesRepository.update(classes);
    }




}
