package com.kawyang.repository;

import com.kawyang.entity.Student;

import java.util.Collection;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@SuppressWarnings("all")
public interface StudentRepository {
    public Collection<Student> findAll();
    public Student findById(long id);
    public void SaveOrUpdate(Student student);
    public void deleteById(long id);
}
