package com.kawyang.controller;

import com.kawyang.entity.Address;
import com.kawyang.entity.Person;
import com.kawyang.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/form")
public class FormHandler {

    /** 通过 get请求获取表单数据 */
    @GetMapping("/get")
    public ModelAndView get(){
        ModelAndView modelAndView = new ModelAndView("form");
        modelAndView.addObject("user",new User(2,"张三", new Address("地址")));

        modelAndView.addObject("person", getPerson());

        return modelAndView;
    }

    private Person getPerson(){
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        person.setAddress(new Address("地址"));

        person.setRemember(true);
        person.setSex("男");


        person.setHobby(Arrays.asList("摄影","读书","听音乐","看电影","旅游","玩游戏"));
        person.setSelecthobby(Arrays.asList("摄影","读书","听音乐"));

        Map<Integer,String> map = new HashMap<>();
        map.put(1, "一年级");
        map.put(2, "二年级");
        map.put(3, "三年级");
        map.put(4, "四年级");
        person.setClassesList(map);
        person.setClasses(3);


        person.setCitys(Arrays.asList("--选择城市--", "山东省","河南省","湖北省","湖南省","广东省","广西自治区","海南省"," 重庆市","四川省","贵州省"));
        person.setCity(person.getCitys().get(0));

        person.setIntroduce("Hello World!...");
        return person;
    }


    @PostMapping("/get")
    @ResponseBody
    public String get(User user, Person person){
        System.out.println(user);
        System.out.println(person);
        return user.toString()+"\n" + person.toString();

    }
}
