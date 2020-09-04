package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * @author LiYang
 * @Project Name: MyBatis-Demo
 * @Package Name: com.yang.entity
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    int id;
    String name;
    int cid;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
                '}';
    }
}
