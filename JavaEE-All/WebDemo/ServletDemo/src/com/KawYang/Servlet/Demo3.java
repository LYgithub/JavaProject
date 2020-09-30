package com.KawYang.Servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.KawYang.Servlet
 * Created by MacBook Air on 2020/06/08.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet(urlPatterns = {"/Demo3", "/DemoTh"})
public class Demo3 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Demo3");

    }
}
