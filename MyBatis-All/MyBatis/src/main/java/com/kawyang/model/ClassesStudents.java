package com.kawyang.model;

import lombok.*;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatis
 * @Package Name: com.kawyang.model
 * Created by MacBook Air on 2020/06/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassesStudents {
    int id;
    String name;
    List<Student> students;
}
