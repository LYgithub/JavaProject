package com.bean;

/**
 * @author LiYang
 * @Project Name: Demo1
 * @Package Name: com.bean
 * Created by MacBook Air on 2020/06/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Add {
    private int data1;
    private int data2;

    public Add() {
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int sum(){
        return this.data1 + this.data2;
    }
}
