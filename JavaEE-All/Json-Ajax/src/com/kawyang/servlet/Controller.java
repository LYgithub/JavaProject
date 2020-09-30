package com.kawyang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Json-Ajax
 * @Package Name: com.kawyang.servlet
 * Created by MacBook Air on 2020/07/02.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Controller extends PersonServlet{

    protected void ajaxController(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
