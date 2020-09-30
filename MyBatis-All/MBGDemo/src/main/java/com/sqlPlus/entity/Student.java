package com.sqlPlus.entity;

/**
 * @author LiYang
 * @Project Name: MBGDemo
 * @Package Name: com.sqlPlus
 * Created by MacBook Air on 2020/06/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Student {
    private int id;
    private String name;
    private int cid;

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cid=" + cid +
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

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
