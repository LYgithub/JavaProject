package com.kawyang.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Json-Ajax-Self
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/08/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */

public class AjaxController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("请求成功！" + req.getMethod());
        System.out.println(req.getParameter("String"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("请求成功！" + req.getMethod());
        System.out.println(req.getParameter("String"));
        System.out.println(req.getParameter("name"));
        resp.getWriter().write("name ====> " + req.getParameter("name"));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
