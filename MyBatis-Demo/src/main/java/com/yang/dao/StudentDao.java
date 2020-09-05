package com.yang.dao;

import com.yang.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.dao
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface StudentDao {
    public Student findById(int id);


    @Select("select * from student")
    public List<Student> findAll();
}
