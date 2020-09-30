package com.kawyang.entity;

import lombok.Data;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class UserList {
    private List<User> users;
}
