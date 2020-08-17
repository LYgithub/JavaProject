package com.kawyang.Test;

import com.kawyang.entity.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.Test
 * Created by MacBook Air on 2020/06/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("springmvc.xml");
        Test test = (Test)context.getBean("test");
        System.out.println(test);
        Test test1 = (Test) context.getBean("test2");
        System.out.println(test1);
    }
}
