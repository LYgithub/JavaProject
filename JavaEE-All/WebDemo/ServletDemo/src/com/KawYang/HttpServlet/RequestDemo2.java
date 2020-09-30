package com.KawYang.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.KawYang.HttpServlet
 * Created by MacBook Air on 2020/06/08.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@WebServlet(urlPatterns = "/youkuHD")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("youku");
        String referer = req.getHeader("referer");
        System.out.println(referer);
        resp.setContentType("text/html;charset=utf-8");
        if(referer != null){
            if(referer.contains("/ServletDemo_war_exploded")){
                resp.getWriter().write("");
                resp.sendRedirect("https://v.youku.com/v_show/id_XMzA4OTA4OTQyMA==.html?spm=a2h0c.8166622.PhoneSokuProgram_1.3");
            }else {
                resp.getWriter().write("<a href='http://www.youku.com'>想看电影？来优酷吧...</a>");
            }
        }else{
            resp.getWriter().write("<a href='http://www.youku.com'>想看电影？来优酷吧...</a>");
        }
    }
}
