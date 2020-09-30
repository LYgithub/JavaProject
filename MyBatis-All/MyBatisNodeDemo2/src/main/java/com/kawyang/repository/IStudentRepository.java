package com.kawyang.repository;

import com.kawyang.entity.ListIds;
import com.kawyang.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IStudentRepository {
    /**
     * find by id
     * @param id
     * @return
     */
    Student findById(int id);

    /**
     * find all
     * @return
     */
    List<Student> findAll();

    /**
     *
     * @param id
     * @return
     */
    @Select("select * from student where cid=#{id}")
    List<Student> findByCid(int id);



    /**
     * find by ids
     * @param listIds
     * @return
     */
    @Select("<script>" +
            "select * from student" +
            "        <where>" +
            "            <if test=\"ids != null and ids.size>0\">" +
            "                <foreach collection=\"ids\"  open=\"id in ( \" close=\")\" separator=\",\" item=\"id\" >" +
            "                    #{id}" +
            "                </foreach>" +
            "            </if>" +
            "        </where> " +
            "</script>")
    List<Student> findByIds(ListIds listIds);


    /**
     * find by student
     * @param student student
     * @return student list
     */
    List<Student> findByStudent(Student student);


    /**
     * find by id
     * @param id
     * @return
     */
    Student findByIdLazy(int id);
}
