package com.kawyang.singleton.innersingletion;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.innersingletion
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class InnerSingleton implements Serializable {
    static final long serialVersionUID = 43L;

    private static class Inner{
        private static InnerSingleton instance = new InnerSingleton();
    }

    private InnerSingleton(){
        if(Inner.instance != null){
            throw new RuntimeException("已经创建过实例！～");
        }
    }

    public static InnerSingleton getInstance(){
        return Inner.instance;
    }

    Object readResolve() throws ObjectStreamException {
        return Inner.instance;
    }

}
