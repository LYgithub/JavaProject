package com.servlet;

import com.util.JDBCutil;
import org.junit.Test;

import javax.servlet.Servlet;
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
public class logServlert extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userName = req.getParameter("userName");
        String password = req.getParameter("passWord");
        System.out.println(userName + password);
        boolean b = JDBCutil.selectLogin(userName, password);
        if(b){
            req.getRequestDispatcher("/page/JSP_Servlet_JDBC/result.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("/error.jsp").forward(req, resp);
        }
//        req.getRequestDispatcher("/page/JSP_Servlet_JDBC/result.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
