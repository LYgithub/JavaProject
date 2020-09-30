package com.yang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: JavaScript
 * @Package Name: ${PACKAGE_NAME}
 * Created by MacBook Air on 2020/09/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class CheckServlet extends javax.servlet.http.HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContextPath());
        /// System.out.println(request.getAttribute("username"));
        System.out.println(request.getParameter("username"));
        HttpSession session = request.getSession();
        session.setAttribute("user", "user");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + ":" + cookie.getValue());
        }
        response.setStatus(404);
        response.sendRedirect("error.html");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContextPath());
    }
}
