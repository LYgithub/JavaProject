package com.kawyang.repository;

import com.kawyang.entity.Student;

import java.util.Collection;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public interface StudentRepository {

    Collection<Student> findAll();

    Student findById(long id);

    void deleteById(long id);

    void saveOrUpdate(Student student);

}
