package com.kawyang.service.impl;

import com.kawyang.entity.Student;
import com.kawyang.repository.IStudent;
import com.kawyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LiYang
 * @Project Name: SSM整合
 * @Package Name: com.kawyang.service.impl
 * Created by MacBook Air on 2020/07/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IStudent student;

    @Override
    public Student findById(int id) {
        return student.findById(id);
    }
}
