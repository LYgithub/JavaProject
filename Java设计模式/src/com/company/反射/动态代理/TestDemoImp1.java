package com.company.反射.动态代理;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.反射.动态代理
 * Created by MacBook Air on 2020/05/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */

interface ITestDemo {
    void test1();
    void test2();
}

public class TestDemoImp1 implements ITestDemo {


    @Override
    public void test1() {
        System.out.println("test1");
    }
    @Override
    public void test2() {
        System.out.println("test2");
    }

}
