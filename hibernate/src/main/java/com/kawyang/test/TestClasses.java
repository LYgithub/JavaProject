package com.kawyang.test;


import com.kawyang.entity.Classes;
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
public class TestClasses {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Object o = session.find(Classes.class,1);
        System.out.println(o);
        session.close();
    }
}
