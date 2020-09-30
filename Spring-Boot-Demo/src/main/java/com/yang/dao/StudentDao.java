package com.yang.dao;

import com.yang.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: SpringBootStrat1
 * @Package Name: com.yang.dao
 * Created by MacBook Air on 2020/09/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Component
public interface StudentDao {
    @Select("select * from student where id=#{id}")
    Student findById(int id);
}
