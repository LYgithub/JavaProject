package com.kawyang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: com.kawyang.model
 * Created by MacBook Air on 2020/06/23.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    int id;
    String name;
    Classes classes;
}
