package com.kawyang.repository.Impl;

import com.kawyang.entity.Student;
import com.kawyang.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.repository.Impl
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Repository
public class StudentrepositoryImpl implements StudentRepository {
    private static Map<Long , Student> studentMap;
    static {
        studentMap = new HashMap<>();
        studentMap.put(1L, new Student(1L, "张三", 23));
        studentMap.put(2L, new Student(2L, "李四", 23));
        studentMap.put(3L, new Student(3L, "王三", 23));
        studentMap.put(4L, new Student(4L, "李三", 23));
    }


    @Override
    public Collection<Student> findAll() {
        return studentMap.values();
    }

    @Override
    public Student findById(long id) {
        return studentMap.get(id);
    }

    @Override
    public void SaveOrUpdate(Student student) {
        studentMap.put(student.getId(), student);
    }

    @Override
    public void deleteById(long id) {
        studentMap.remove(id);
    }
}
