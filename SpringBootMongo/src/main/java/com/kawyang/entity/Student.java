package com.kawyang.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author LiYang
 * @Project Name: SpringBootMongo
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@Document(collection = "student")
public class Student {

    /** test*/
    @Id
    private String id;
    @Field("name")
    private String name;
    @Field
    private int age;
}
