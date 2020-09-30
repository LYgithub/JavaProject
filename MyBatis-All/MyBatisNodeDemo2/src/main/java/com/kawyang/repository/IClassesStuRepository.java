package com.kawyang.repository;

import com.kawyang.entity.ClassesStu;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IClassesStuRepository {
    /**
     * find classesStu by id
     * @param id key
     * @return classesStu
     */
    ClassesStu findById(int id);

    /**
     * find all classesStu
     * @return classesStu list
     */
    List<ClassesStu> findAll();
}
