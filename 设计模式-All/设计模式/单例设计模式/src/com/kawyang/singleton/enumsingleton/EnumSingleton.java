package com.kawyang.singleton.enumsingleton;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.Enum
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public enum EnumSingleton {
    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}
