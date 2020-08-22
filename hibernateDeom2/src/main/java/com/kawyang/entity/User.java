package com.kawyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiYang
 * @Project Name: hibernateDeom2
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/08/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Integer id;
    String userName;
    String passWord;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
