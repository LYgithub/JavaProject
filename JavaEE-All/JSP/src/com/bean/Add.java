package com.bean;

/**
 * @author LiYang
 * @Project Name: JSP
 * @Package Name: Bean
 * Created by MacBook Air on 2020/05/30.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Add {
    private int date1;
    private int date2;

    public Add() {
    }

    public int getDate1() {
        return date1;
    }

    public void setDate1(int date1) {
        this.date1 = date1;
    }

    public int getDate2() {
        return date2;
    }

    public void setDate2(int date2) {
        this.date2 = date2;
    }
    public int sum(){
        return this.date1 + this.date2;
    }
}
