package com.kawyang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author LiYang
 * @Project Name: Hibernate-HQL
 * @Package Name: com.kawyang.dao
 * Created by MacBook Air on 2020/08/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    String sex;
    int age;
    Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
