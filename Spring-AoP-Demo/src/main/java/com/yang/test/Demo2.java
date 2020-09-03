package com.yang.test;

import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.test
 * Created by MacBook Air on 2020/09/03.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
@Component("demo2")
public class Demo2 {
    public String method1(String arg1, int id){
        System.out.println("———————  Start method2  ———————");
        // 抛出异常
        int x = 1 / 0;
        System.out.println("———————  End method2  ———————");
        return "返回值";
    }

}
