package com.servlet;

import com.util.JDBCUtil;

import javax.servlet.ServletContext;
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
 * Created by MacBook Air on 2020/06/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
        this.getServletContext();
        ServletContext servletContext = req.getServletContext();
        String file = "a.jpg";
        String mimeType = servletContext.getMimeType(file);
        System.out.println(mimeType);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("inputUsername");
        String password = req.getParameter("inputPassword");
        String checkCode = req.getParameter("");
        if("".equals(checkCode)){
            System.out.println(checkCode);
        }
        if (JDBCUtil.loginCheck(username,password)){
            req.getRequestDispatcher("welcome.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("Error.html").forward(req,resp);
        }
    }
}
