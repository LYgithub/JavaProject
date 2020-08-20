package com.servlet.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: HomeWork
 * @Package Name: ${PACKAGE_NAME}
 * Created by MacBook Air on 2020/06/11.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数
        String filename = request.getParameter("filename");
        //2.使用字节输入流加载进内存
        //2.1 找到真实路径

        ServletContext servletContext = this.getServletContext();
        String path = servletContext.getRealPath("/img/" + filename);
        //2.2 关联字节流
        FileInputStream fileInputStream = new FileInputStream(path);
        //3. 设置response的响应头
        //MIME 类型
        String mimeType = servletContext.getMimeType(path);
        response.setHeader("content-type", mimeType);
        //打开方式
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        // 4.
        ServletOutputStream outputStream = response.getOutputStream();
        byte[]buff = new byte[1024 * 8];
        int len;
        while((len = fileInputStream.read(buff)) != -1){
            outputStream.write(buff, 0, len);
        }

        outputStream.close();
        fileInputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
