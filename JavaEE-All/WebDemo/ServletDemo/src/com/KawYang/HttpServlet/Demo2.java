package com.KawYang.HttpServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: ${PACKAGE_NAME}
 * Created by MacBook Air on 2020/06/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/Request/Demo2")
public class Demo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getAttribute("name").toString());
        System.out.println("===========");
        ServletContext servletContext = request.getServletContext();
        System.out.println(servletContext);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
