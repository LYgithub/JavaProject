package com.kawyang.entity;

/**
 * @author LiYang
 * @Project Name: Spring-Ioc-Printer
 * @Package Name: com.kawyang.entity
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Printer {
    private Paper paper = null;

    public void print(String str) {

        for (int i = 0; i < str.length(); i++) {
            paper.putIntChar(str.charAt(i));
        }

        System.out.println(paper.getContext());
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
