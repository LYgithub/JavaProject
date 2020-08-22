package com.kawyang.dao;

import com.kawyang.entity.Student;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: Hibernate-HQL
 * @Package Name: com.kawyang.dao
 * Created by MacBook Air on 2020/08/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IStudent {
    Student findById(int id);

    Student findByHQL(String hql);

    List<Student> findSome();


    void save(Student student);
    void update(Student student);
    void delete(Student student);
}
