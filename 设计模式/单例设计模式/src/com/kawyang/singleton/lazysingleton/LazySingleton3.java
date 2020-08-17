package com.kawyang.singleton.lazysingleton;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.lazysingleton
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class LazySingleton3 {
    private static LazySingleton3 instance;
    private LazySingleton3(){}

    /**
     * double check
     * @return
     */
    public static LazySingleton3 getInstance(){
        if(instance == null){
            synchronized (LazySingleton3.class){
                if (instance == null){
                    instance = new LazySingleton3();
                }
            }
        }
        return instance;
    }

    public void print(){
        System.out.println(instance);
    }
}
