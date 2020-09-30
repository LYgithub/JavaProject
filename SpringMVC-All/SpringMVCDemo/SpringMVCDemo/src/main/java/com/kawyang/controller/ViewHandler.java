package com.kawyang.controller;
import com.kawyang.entity.Address;
import com.kawyang.entity.User;

import com.kawyang.entity.UserList;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/view")

@SessionAttributes(value = "user", types = {User.class, UserList.class})
//@SessionAttributes(types ={User.class, UserList.class})
public class ViewHandler {
    @RequestMapping("/map")
    public String map(Map<String, User> user){
        User user1 = new User();
        user1.setId(1);
        user1.setName("李四");
        user.put("user", user1);
        return "view";
    }

    @RequestMapping("/model")
    public String model(Model model){
        User user1 = new User();
        user1.setId(1);
        user1.setName("李四");
        model.addAttribute("user", user1);
        return "view";
    }

    @RequestMapping("/modelandview")
    public ModelAndView modelAndView(ModelAndView modelAndView ){
        User user1 = new User();
        user1.setId(3);
        user1.setName("李四");
        modelAndView.addObject("user", user1);
        modelAndView.setViewName("view");
        return modelAndView;

    }

    @RequestMapping("/modelandview2")
    public ModelAndView modelAndView2(){
        User user1 = new User();
        user1.setId(4);
        user1.setName("modelandview2");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user1);
        View view = new InternalResourceView("/view.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }


    @RequestMapping("/modelandview3")
    public ModelAndView modelAndView3(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("modelandview3");

        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("user", user1);
        return modelAndView;
    }

    @RequestMapping("/modelandview4")
    public ModelAndView modelAndView4(){
        User user1 = new User();
        user1.setId(1);
        user1.setName("modelandview4");

        View view = new InternalResourceView("/view.jsp");
        Map<String,User> map = new HashMap<>(2);
        map.put("user", user1);
        ModelAndView modelAndView = new ModelAndView(view,map);
//        ModelAndView modelAndView1 = new ModelAndView(view);
//        modelAndView1.
//        addObject("user", user1);

//        ModelAndView modelAndView1 = new ModelAndView("view", "user", user1);
        return modelAndView;
    }

    @RequestMapping("/request")
    public String request(HttpServletRequest request){
        User user1 = new User();
        user1.setId(1);
        user1.setName("request");

        request.setAttribute("user", user1);
        return "view";
    }

    @ModelAttribute
    public User getUser(){
        return new User(1, "ModelAttribute", new Address());
    }


    public User getUser2(){
        return new User(1, "ModelAttribute", new Address());
    }

    @ModelAttribute
    public void getUser(Map<String, User> map){
        User user = new User(1, "ModelAttribute", new Address());
        map.put("user", user);
    }
    @ModelAttribute
    public void getUser(Model model){
        User user = new User(1, "ModelAttribute", new Address());
        model.addAttribute("user", user);
    }
    @RequestMapping("/ModelAttribute")
    public String modelattribute(){
        return "view";
    }


    @RequestMapping("/session")
    public String session(HttpServletRequest request){
        User user2 = getUser2();
        HttpSession session = request.getSession();
        session.setAttribute("user", user2);
        return "view";
    }


    @RequestMapping("/session2")
    public String session(HttpSession session){
        User user2 = getUser2();
        session.setAttribute("user", user2);
        return "view";
    }


    @RequestMapping("/application")
    public String application(HttpServletRequest request){
        ServletContext servletContext = request.getSession().getServletContext();
        servletContext.setAttribute("user", getUser2());
        return "view";

    }
}
