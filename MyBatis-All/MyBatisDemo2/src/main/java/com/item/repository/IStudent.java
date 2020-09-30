package com.item.repository;

import com.item.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item
 * Created by MacBook Air on 2020/06/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IStudent{

    /**
     * find all
     * @return
     * 单标查询
     */
    List<Student> findAll();

    /**
     * find by All
     * @return
     * 多表查询
     */
    List<Student> findByAll();

    /**
     * find
     * @param id
     * @return
     */
    Student findById(int id);

    /**
     * 插入信息
     * @param student
     * @return
     */
    int insertStudent(Student student);


    /**
     * 删除学生信息
     * @param id
     * @return
     */
    int delectStudentByID(int id);


    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);


}
