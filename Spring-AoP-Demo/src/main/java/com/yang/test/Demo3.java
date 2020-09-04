package com.yang.test;

import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.test
 * Created by MacBook Air on 2020/09/04.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Component
public class Demo3 {
    public String method(String arg1, int arg2){
        System.out.println("———————  Start method  ———————");
        // 抛出异常
        int x = 1 / 0;
        System.out.println("———————  End method  ———————");
        return "";
    }

    public String method2(String arg1, int arg2){
        System.out.println("———————  Start method2  ———————");
        return "Annotation-Return";
    }
}
