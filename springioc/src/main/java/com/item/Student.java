package com.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiYang
 * @Project Name: springioc
 * @Package Name: com.item
 * Created by MacBook Air on 2020/06/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
public class Student {
    int id;
    String name;
    int age;
    Classes classes;

    public Student() {
        System.out.println("Student创建！");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
