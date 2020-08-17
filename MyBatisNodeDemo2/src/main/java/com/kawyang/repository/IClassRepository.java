package com.kawyang.repository;

import com.kawyang.entity.Classes;
import com.kawyang.entity.ClassesStu;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/07/03.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IClassRepository {
    /**
     * find by id
     * @param id
     * @return
     */
    Classes findById(int id);


    /**
     * find
     * @param id
     * @return
     */
    ClassesStu findByIdLazy(int id);
}
