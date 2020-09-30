package com.kawyang.repository;

import com.kawyang.entity.Good;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IGoodRepository {
    /**
     * find by id
     * @param id
     * @return Good
     */
    Good findById(int id);

    /**
     * find all
     * @return good list
     */
    List<Good> findAll();

    /**
     * find good not has consumer
     * @param id
     * @return
     */
    Good findGoodById(int id);
}
