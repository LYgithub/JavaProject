package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: HomeWork
 * @Package Name: com.servlet
 * Created by MacBook Air on 2020/06/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo1....");

        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //自动跳转到Demo2  重定向
        //设置状态码
        resp.setStatus(302);
        // 设置头
        resp.setHeader("location", contextPath + "/responseDemo2");

//        resp.sendRedirect("/HomeWork/responseDemo2");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
