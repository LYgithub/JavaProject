package com.kawyang.test;

import com.kawyang.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author LiYang
 * @Project Name: hibernate
 * @Package Name: com.kawyang.test
 * Created by MacBook Air on 2020/08/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Student student = new Student();
        session.save(student);
        session.beginTransaction().commit();
        session.close();
    }
}
