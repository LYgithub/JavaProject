package com.KawYang.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.KawYang.HttpServlet
 * Created by MacBook Air on 2020/06/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/Demo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        System.out.println(req.getParameter("userName"));
        System.out.println(req.getMethod());

        String[] hobbies = req.getParameterValues("hobby");
        for (String s:hobbies) {
            System.out.println(s);
        }

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s + ":" + req.getParameter(s));
        }


        System.out.println("=======");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> key = parameterMap.keySet();
        for(String s : key){
            System.out.println(s + ":" + Arrays.toString(parameterMap.get(s)));
        }
        req.getRequestDispatcher("http://www.baidu.com").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
