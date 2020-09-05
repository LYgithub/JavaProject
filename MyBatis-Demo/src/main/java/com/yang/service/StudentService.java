package com.yang.service;

import com.yang.dao.StudentDao;
import com.yang.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.service
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao ;

    public Student findById(int id){
        return studentDao.findById(id);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }
}
