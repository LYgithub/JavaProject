package com.kawyang.repository.impl;

import com.kawyang.entity.Student;
import com.kawyang.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.repository.Impl
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private static Map<Long, Student> students;

    static {
        students = new HashMap<>();
        students.put(1L, new Student(1L, "张三", 12));
        students.put(2L, new Student(2L, "李四", 13));
        students.put(3L, new Student(3L, "王五", 14));
    }


    @Override
    public Collection<Student> findAll() {
        return students.values();
    }

    @Override
    public Student findById(long id) {
        return students.get(id);
    }

    @Override
    public void deleteById(long id) {
        students.remove(id);
    }

    @Override
    public void saveOrUpdate(Student student) {
        students.put(student.getId(), student);
    }
}
