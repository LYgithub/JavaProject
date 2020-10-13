package com.company;

import org.w3c.dom.Text;

/**
 * @author LiYang
 * @Project Name: 反射
 * @Package Name: com.company
 * Created by MacBook Air on 2020/10/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public int id;
    private String name;

    public Test(){
        id = 1;
        name = "yang";
    }

    public Test(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void print(){
        System.out.println(this.id + "==>" + this.name);
    }

    private String selfPrint(String name){
        System.out.println("selfPrint ==> " + name);
        return name;
    }
}
