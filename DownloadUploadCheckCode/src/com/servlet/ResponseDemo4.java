package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author LiYang
 * @Project Name: HomeWork
 * @Package Name: com.servlet
 * Created by MacBook Air on 2020/06/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Demo3...");
        // 默认 ISO-8859 TomCat
        resp.setCharacterEncoding("utf8");

        //告诉浏览器编码 包含设置 TomCat
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        //简单方式
        resp.setContentType("text/html;charset=utf-8");

        //字节输出流
        PrintWriter writer = resp.getWriter();
        writer.write("Hello Response");
        //window  JBK， JB132
        writer.write("你好！！");



    }
}