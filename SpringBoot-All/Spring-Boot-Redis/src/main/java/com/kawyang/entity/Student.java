package com.kawyang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LiYang
 * @Project Name: Spring-Boot-Redis
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/30.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
public class Student implements Serializable {
    private long id;
    private String name;
    private int age;
}
