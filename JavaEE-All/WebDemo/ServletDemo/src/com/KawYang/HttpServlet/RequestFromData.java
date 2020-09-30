package com.KawYang.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.KawYang.HttpServlet
 * Created by MacBook Air on 2020/06/08.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/formData")
public class RequestFromData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("======");
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
