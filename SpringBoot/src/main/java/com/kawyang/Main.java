package com.kawyang;

import com.kawyang.repository.Impl.StudentRepositoryImpl;
import com.kawyang.repository.StudentRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Main {
    public static void main(String[] args) {

        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext();
        System.out.println(classPathXmlApplicationContext.getBean(StudentRepositoryImpl.class));
        StudentRepository studentRepositoryImpl =(StudentRepositoryImpl) classPathXmlApplicationContext.getBean("studentRepositoryImpl");
        System.out.println(studentRepositoryImpl.findAll());

    }
}
