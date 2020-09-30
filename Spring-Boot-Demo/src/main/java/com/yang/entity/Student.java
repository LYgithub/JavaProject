package com.yang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: SpringBootStrat1
 * @Package Name: com.yang.entity
 * Created by MacBook Air on 2020/09/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Student {
    @Value("1")
    int id;

    @Value("yang")
    String name;
}
