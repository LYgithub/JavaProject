package com.yang.test;

import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: Spring-AoP-Demo
 * @Package Name: com.yang.test
 * Created by MacBook Air on 2020/09/01.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
@Component("demo")
public class Demo {
    public String method1(String arg1, int id){
        try {
            System.out.println("———————  Start method  ———————");
            int x = 1 / 0;
            System.out.println(x);
            return "Finish";
        }catch (Exception e){
            return "返回值:Error";
        }
        finally {
            System.out.println("———————  End method  ———————");
        }
    }
}
