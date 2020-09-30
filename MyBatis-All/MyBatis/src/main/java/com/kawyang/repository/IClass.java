package com.kawyang.repository;

import com.kawyang.model.Classes;
import com.kawyang.model.ClassesStudents;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: com.kewyang.repository
 * Created by MacBook Air on 2020/06/23.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * 增删改查练习
 */
@SuppressWarnings("all")
public interface IClass {
    Classes findById(int id);

    List<Classes> findAll();

    @Insert("insert into classes (id,name) values (#{id}, #{name})")
    int insertClass(Classes classes);

    int deleteById(int id);

    int updateClass(Classes classes);

    ClassesStudents findClassAndStudentById(int id);

    List<ClassesStudents> findAllClassAndStudent();
}
