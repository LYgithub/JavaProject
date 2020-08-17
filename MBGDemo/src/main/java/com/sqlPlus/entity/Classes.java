package com.sqlPlus.entity;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MBGDemo
 * @Package Name: com.sqlPlus
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Classes {
    private int id;
    private String name;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
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
