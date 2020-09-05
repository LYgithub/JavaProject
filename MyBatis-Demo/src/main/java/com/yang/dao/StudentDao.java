package com.yang.dao;

import com.yang.entity.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


    @Insert("insert into student (id, name, cid) value(#{id},#{name},#{cid})")
    public int insert(Student student);

    @Delete("delete from student where id=#{0}")
    public int delete(int id);

    @Update("update student set name=#{name} where id=#{id}")
    int update(Student student);


}
