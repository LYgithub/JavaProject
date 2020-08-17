package com.kawyang.bean;

/**
 * @author LiYang
 * @Project Name: Json-Ajax
 * @Package Name: com.kawyang.bean
 * Created by MacBook Air on 2020/07/02.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
