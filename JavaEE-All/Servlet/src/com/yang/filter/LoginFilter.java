package com.yang.filter;

import javax.servlet.*;
import java.io.IOException;


/**
 * @author LiYang
 * @Project Name: Servlet
 * @Package Name: com.yang.filter
 * Created by MacBook Air on 2020/09/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter - init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter - doFilter");
        // 获取 客户端发送的数据
        String username  = servletRequest.getParameter("username");
        System.out.println(username);
        if ("".equals(username) || username == null){
            // 转发
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }else{
            servletRequest.getRequestDispatcher("/admin/index.jsp").forward(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter - destroy");
    }
}
