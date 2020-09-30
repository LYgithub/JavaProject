package com.kawyang.controller;

import com.kawyang.entity.Account;
import com.kawyang.entity.Person2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/validator")
public class LoginHandler {

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("account", new Account());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated Account account, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            System.out.println("======>"+bindingResult.getAllErrors());
//            return "forword:/validator/login";
            return "login";
        }
//        model.addAttribute("account", account);
        if (isLogin(account)){
            return "success";
        }else {
            return "error";
        }
    }

    private boolean isLogin(Account account){
        return "123".equals(account.getName()) && "123".equals(account.getPassword());
    }

    @GetMapping("/login2")
    public String login2(Model model){
        Person2 person2 = new Person2();
        model.addAttribute("person2", person2);
        return "login2";
    }

    @PostMapping("/login2")
    public String login2(Model model, @Valid Person2 person2, BindingResult bindingResult){
        System.out.println(person2);
        model.addAttribute("p", person2);
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "login2";
        }
        return "success";
    }
}
