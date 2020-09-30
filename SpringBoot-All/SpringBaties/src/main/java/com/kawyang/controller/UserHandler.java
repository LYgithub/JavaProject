package com.kawyang.controller;

import com.kawyang.entity.MyUser;
import com.kawyang.repository.UserRepository;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBaties
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@RestController
@RequestMapping("/myuser")
public class UserHandler {

    @Autowired
    @SuppressWarnings("all")
    private UserRepository userRepository;

    @GetMapping("/findAll")
    public List<MyUser> findAll(){
        return userRepository.findAll();
    }

    @GetMapping("/findById/{id}")
    public MyUser findById(@PathVariable long id){
        System.out.println("findById======>"+ id);
        return userRepository.findById(id);
    }

    @PostMapping("/insert")
    public int insert(@RequestBody MyUser myUser){
        return userRepository.insert(myUser);
    }

    @PostMapping("/update")
    public int update(@RequestBody MyUser myUser){
        return userRepository.update(myUser);
    }


    @GetMapping("/deleteById/{id}")
    public int delete(@PathVariable long id){
        System.out.println("deleteById=======>" + id);
        return userRepository.deleteById(id);
    }

}
