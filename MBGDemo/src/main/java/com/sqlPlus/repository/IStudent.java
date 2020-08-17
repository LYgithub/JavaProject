package com.sqlPlus.repository;

import com.sqlPlus.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MBGDemo
 * @Package Name: com.sqlPlus.repository
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IStudent {
    /**
     * 查询全部
     * @return 查询结果
     */
//    @Select("select * from student")
    List<Student> findAll();
}
