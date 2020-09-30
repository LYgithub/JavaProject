package com.yang.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author LiYang
 * @Project Name: Servlet
 * @Package Name: com.yang.listener
 * Created by MacBook Air on 2020/09/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MyServletListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器初始化...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器销毁...");
    }
}
