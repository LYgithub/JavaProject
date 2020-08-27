package com.yang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/08/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
// 自动注入文件
@Component("person")
public class Person {
    @Value("KawYang")
    String name;

    int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
