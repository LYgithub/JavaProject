package com.kawyang.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author LiYang
 * @Project Name: SpringJPA
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/06/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int cid;
}
