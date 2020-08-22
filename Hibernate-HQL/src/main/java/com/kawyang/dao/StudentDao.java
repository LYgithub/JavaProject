package com.kawyang.dao;

import com.kawyang.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: Hibernate-HQL
 * @Package Name: com.kawyang.dao
 * Created by MacBook Air on 2020/08/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class StudentDao implements IStudent{
    private final Configuration configuration = new Configuration().configure();
    private final SessionFactory sessionFactory = configuration.buildSessionFactory();


    @Override
    public Student findByHQL(String hql) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        //query.setParameter("name","KawYang");
        List<Student> list = query.list();
        list.forEach(System.out::println);
        return null;
    }

    @Override
    public Student findById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.find(Student.class, 1);
        System.out.println(student.toString());
        return null;
    }

    @Test
    public void testFindById() {
        findByHQL("from Student s where s.id=1");
        findById(1);
    }

    @Override
    public List<Student> findSome() {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }
}
