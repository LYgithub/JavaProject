package com.kawyang.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author LiYang
 * @Project Name: SpringBaties
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class MyUser {
    private Long id;
    private String name;
    private Integer age;
    private Date birthday;
}
