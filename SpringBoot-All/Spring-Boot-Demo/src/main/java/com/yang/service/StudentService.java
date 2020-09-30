package com.yang.service;

import com.yang.entity.Student;
import org.springframework.stereotype.Service;

/**
 * @author LiYang
 * @Project Name: SpringBootStrat1
 * @Package Name: com.yang.service
 * Created by MacBook Air on 2020/09/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Service
public class StudentService {
    public Student findById(int id) {
        return new Student(id,"student");
    }
}
