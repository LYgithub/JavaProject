package com.item.entity;

import java.io.Serializable;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item
 * Created by MacBook Air on 2020/06/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Student implements Serializable {
    private int id;
    private String name;
    private Classes_ classes;



    @Override
    public String toString() {
        return "Student_Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classes=" + classes +
                '}';
    }

    public Student() {
    }

    public Student(int id, String name, Classes_ classes) {
        this.id = id;
        this.name = name;
        this.classes = classes;
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

    public Classes_ getClasses() {
        return classes;
    }

    public void setClasses(Classes_ classes) {
        this.classes = classes;
    }
}
