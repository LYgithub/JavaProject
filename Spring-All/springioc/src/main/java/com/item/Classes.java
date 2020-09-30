package com.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class Classes {
    int id;
    String name;

    public Classes() {
        System.out.println("Classes创建对象");
    }

    public Classes(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

