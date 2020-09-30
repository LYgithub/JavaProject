package com.kawyang.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiYang
 * @Project Name: SpringBoot
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    long id;
    String name;
    int age;
}
