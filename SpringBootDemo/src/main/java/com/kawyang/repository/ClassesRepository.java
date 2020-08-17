package com.kawyang.repository;

import com.kawyang.entity.Classes;
import com.kawyang.entity.Student;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBootDemo
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public interface ClassesRepository {
    List<Classes> findAll();

    Classes findById(int id);

    int deleteById(int id);

    int save(Classes classes);

    int update(Classes classes);

}
