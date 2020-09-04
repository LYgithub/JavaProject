package com.yang.dao;

import com.yang.entity.Student;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.dao
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IStudentDao {
    public Student findById(int id);
}
