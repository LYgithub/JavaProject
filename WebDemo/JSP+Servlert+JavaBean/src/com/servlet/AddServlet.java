package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.servlet
 * Created by MacBook Air on 2020/06/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        /**
         * 两者区别：
         * ①getParameter()获取的是客户端设置的数据。
         * getAttribute()获取的是服务器设置的数据。
         * ②getParameter()永远返回字符串
         * getAttribute()返回值是任意类型
         * https://blog.csdn.net/wz2292667460/article/details/79366493
         */
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        int x = Integer.parseInt(data1);
        int y = Integer.parseInt(data2);
        int sum = x + y;
        req.setAttribute("sum", sum);
        req.getAttribute("data1");
        req.getRequestDispatcher("Page3.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
