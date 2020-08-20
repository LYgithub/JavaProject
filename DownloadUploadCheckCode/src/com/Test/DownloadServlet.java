package com.Test;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: DownloadUploadCheckCode
 * @Package Name: com.Test
 * Created by MacBook Air on 2020/08/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@WebServlet("/download/img")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取数据名称
        String filename = req.getParameter("filename");
        String realPath = this.getServletContext().getRealPath("/img/" + filename);
        // 2. 将数据加载进内存
        FileInputStream fileInputStream = new FileInputStream(new File(realPath));
        // 3. 设置请求信息
        String mimeType = this.getServletContext().getMimeType(realPath);
        resp.setHeader("content-type", mimeType);
        resp.setHeader("content-disposition","attachment;filename=" + filename);
        // 4. 数据提交到网络
        ServletOutputStream outputStream = resp.getOutputStream();
        int len;
        byte [] buffer = new byte[1024];
        while ((len = fileInputStream.read(buffer)) != -1){
            outputStream.write(buffer,0,len);
        }

        outputStream.close();
        fileInputStream.close();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
