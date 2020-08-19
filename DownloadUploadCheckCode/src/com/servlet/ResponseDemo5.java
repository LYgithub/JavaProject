package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author LiYang
 * @Project Name: HomeWork
 * @Package Name: com.servlet
 * Created by MacBook Air on 2020/06/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/responseDemo5")
public class ResponseDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        resp.setContentType("text/html;charset=utf-8");
        outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
        outputStream.write("你好".getBytes("utf-8"));
    }
}