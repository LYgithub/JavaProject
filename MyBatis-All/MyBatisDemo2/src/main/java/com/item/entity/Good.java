package com.item.entity;

import java.util.List;

/**
 * @author LiYang
 * @Project Name: MyBatisDemo2
 * @Package Name: com.item.entity
 * Created by MacBook Air on 2020/06/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Good {
    private int id;
    private String name;
    private List<Consumer> consumers ;

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", consumers=" + consumers +
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

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }
}
