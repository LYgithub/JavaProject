package com.yang.controller;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author LiYang
 * @Project Name: JavaScript
 * @Package Name: com.yang.controller
 * Created by MacBook Air on 2020/09/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("------  upload  -------");
        String path = System.getProperty("user.dir");
        System.out.println(path);
        ServletInputStream inputStream = req.getInputStream();
        int len;
        String contentType = req.getContentType();
        System.out.println(contentType);
        byte [] b = new byte[1024 * 10];
        req.setCharacterEncoding("utf-8");
        ///
        for (int i = 0; i < 5; i++) {
            System.out.println(inputStream.readLine(b, 0, 100));
            System.out.println(b.toString());
        }
        OutputStream out = new FileOutputStream(new File(path + "/file.jpg"));
        while ((len = inputStream.read(b)) > 0){
            /// System.out.println("==>"+new String(b,0,len));
            out.write(b,0,len);
        }
        out.flush();
        inputStream.close();
        out.close();
    }


}
