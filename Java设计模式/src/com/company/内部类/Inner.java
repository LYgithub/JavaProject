package com.company.内部类;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.内部类
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Inner {
    public static void main(String[] args) {
        A a = new A();
        a.getMethod();
        B b = new B();
        b.testB();

    }
}

/**
 * 内部类解决Java不能多重继承的问题
 * A 类 想获取 B和C类的属性或方法
 */
class A{
    class InnerB extends B{
        @Override
        void testB() {
            System.out.println(super.id);
            System.out.println("A:B:testB");
        }
    }

    class InnerC extends C{
        @Override
        void testC() {
            super.testC();
            System.out.println("A:C:testC");
        }
    }

    void getMethod(){
        InnerB b = new InnerB();
        b.testB();
        InnerC c = new InnerC();
        c.testC();
    }
}

class B {
    int id = 1;
    void testB(){
        System.out.println("B:testB");
    }
}

class C{
    void testC(){
        System.out.println("C:testC");
    }
}