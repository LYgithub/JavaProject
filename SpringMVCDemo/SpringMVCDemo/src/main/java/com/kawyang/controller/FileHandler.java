package com.kawyang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.controller
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Controller

@RequestMapping("/file")
public class FileHandler {

    @PostMapping("/upload")
    //需要进行配置上传解析器
    public String upload(MultipartFile img, HttpServletRequest request){
        System.out.println(img);
        if(img.getSize() > 0){

            String contextPath = request.getSession().getServletContext().getRealPath("file");
            String name = img.getOriginalFilename();
            System.out.println(contextPath);
            File file = new File(contextPath, name);
            try {
                img.transferTo(file);

                request.setAttribute("path","/file/" + name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "upload";
    }


    @PostMapping("/uploads")
    public String uploads(MultipartFile[] imgs, HttpServletRequest request){
        List<String>  files = new ArrayList<>();
        for(MultipartFile img:imgs){
            if(img.getSize() > 0){

                String contextPath = request.getSession().getServletContext().getRealPath("file2");
                String name = img.getOriginalFilename();
                System.out.println(contextPath);
                File file = new File(contextPath, name);
                try {
                    img.transferTo(file);
                    files.add("/file2/"+name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        request.setAttribute("files", files);
        return "upload";
    }
}
