package com.kawyang.repository;

import com.kawyang.entity.Consumer;
import com.kawyang.entity.Student;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisNodeDemo2
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/07/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface IConsumerRepository {
    /**
     * find by id
     * @param id
     * @return
     */
    Consumer findById(int id);

    /**
     * find all
     * @return
     */
    List<Consumer> findAll();
}
