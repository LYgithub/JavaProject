package com.kawyang.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller
@RequestMapping("/file")
public class DownloadHandler {

    @GetMapping("/download/{name}")
    public void download(@PathVariable("name") String name, HttpServletRequest request, HttpServletResponse response){
        System.out.println(name);
        if(name != null){
            String path = request.getSession().getServletContext().getRealPath("file2");
            File file = new File(path, name+".png");
            OutputStream out = null;
            if(file.exists()){
                response.setContentType("application/forc-download");
                //指定下载后的文件名
                response.setHeader("Content-Disposition","attachment;filename="+name + ".png");
                try {
                    out = response.getOutputStream();
                    out.write(FileUtils.readFileToByteArray(file));
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (out != null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }
}
