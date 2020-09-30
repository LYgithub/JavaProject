package com.KawYang.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.KawYang.HttpServlet
 * Created by MacBook Air on 2020/06/08.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet(urlPatterns = "/Request/Demo1")
public class Demo1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "张三");
        req.getRequestDispatcher("Demo2").forward(req, resp);

        System.out.println("Request_Demo1");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
