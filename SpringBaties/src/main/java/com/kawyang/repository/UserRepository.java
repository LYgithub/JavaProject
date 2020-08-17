package com.kawyang.repository;

import com.kawyang.entity.MyUser;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringBaties
 * @Package Name: com.kawyang.repository
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */

public interface UserRepository {
    /**
     * findAll
     * @return
     */
    List<MyUser> findAll();

    /**
     * findById
     * @param id
     * @return
     */
    MyUser findById(long id);

    /**
     * deleteById
     * @param id
     * @return
     */
    int deleteById(long id);

    /**
     * update
     * @param user
     * @return
     */
    int update(MyUser user);

    /**
     * insert
     * @param user
     * @return
     */
    int insert(MyUser user);
}
