package com.kawyang.dao;

import com.kawyang.entity.User;

/**
 * @author LiYang
 * @Project Name: hibernateDeom2
 * @Package Name: com.kawyang.dao
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public interface IUserDao {
    User findById(int id);
    int insertUser(User user);
    void updateUser(User user);
    int deleteById(User user);
}

