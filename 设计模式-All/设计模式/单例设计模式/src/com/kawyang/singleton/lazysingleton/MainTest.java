package com.kawyang.singleton.lazysingleton;


import org.junit.Test;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.lazysingleton
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MainTest {
    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        instance.print();
        LazySingleton instance1 = LazySingleton.getInstance();
        instance1.print();
        System.out.println(instance == instance1);
    }


    /**
     * 存在线程不安全的情况
     * com.kawyang.singleton.lazysingleton.LazySingleton@237d13ca
     * com.kawyang.singleton.lazysingleton.LazySingleton@607fdf96
     * @throws InterruptedException
     */
    @Test
    public void test() throws InterruptedException {
        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            instance.print();
        }).start();
        new Thread(()->{
            LazySingleton instance = LazySingleton.getInstance();
            instance.print();
        }).start();
        Thread.sleep(2000);
    }


    @Test
    public void test2() throws InterruptedException {
        new Thread(()->{
            LazySingleton2 instance = LazySingleton2.getInstance();
            instance.print();
        }).start();
        new Thread(()->{
            LazySingleton2 instance = LazySingleton2.getInstance();
            instance.print();
        }).start();
        Thread.sleep(2000);
    }

    @Test
    public void test3() throws InterruptedException {
        new Thread(()->{
            LazySingleton3 instance = LazySingleton3.getInstance();
            instance.print();
        }).start();
        new Thread(()->{
            LazySingleton3 instance = LazySingleton3.getInstance();
            instance.print();
        }).start();
        Thread.sleep(2000);
    }
}
