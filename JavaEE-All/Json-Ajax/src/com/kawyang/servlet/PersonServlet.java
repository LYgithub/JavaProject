package com.kawyang.servlet;

import com.google.gson.Gson;
import com.kawyang.bean.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Json-Ajax
 * @Package Name: com.kawyang.servlet
 * Created by MacBook Air on 2020/07/02.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PersonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do get ...");
        Person person = new Person(1,"张三");
        resp.setContentType("text/html;charset=UTF-8");
        Gson gson = new Gson();

        System.out.println("name =====> "+req.getParameter("name"));
        String s = gson.toJson(person);
        resp.getWriter().write(s);
        Person person1 = gson.fromJson(s, Person.class);
        System.out.println(person1);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
