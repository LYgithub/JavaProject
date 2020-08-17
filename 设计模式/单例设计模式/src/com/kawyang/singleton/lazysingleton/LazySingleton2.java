package com.kawyang.singleton.lazysingleton;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.lazysingleton
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LazySingleton2 {
    private static LazySingleton2 instance;
    private LazySingleton2(){}

    /**
     * 添加程序🔒，解决线程安全问题
     * 但是当创建实例对象后，不断获取会降低获取效率不断加锁。
     * LazySingleton 问题所在：
     *      当两个线程几乎同时进入 if ，是出现问题的关键
     *      只需要在 if 内部添加程序🔒，以提高程序的效率
     * @return
     */
    public synchronized static LazySingleton2 getInstance(){
        if(instance == null){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton2();
        }
        return instance;
    }

    public void print(){
        System.out.println(instance);
    }
}
