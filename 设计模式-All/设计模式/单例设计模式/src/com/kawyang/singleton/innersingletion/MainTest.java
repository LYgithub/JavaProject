package com.kawyang.singleton.innersingletion;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.singleton.innersingletion
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MainTest {
    @Test
    public void test1(){
        InnerSingleton instance = InnerSingleton.getInstance();
        InnerSingleton instance1 = InnerSingleton.getInstance();
        //使用断言进行验证
        Assert.assertEquals(true, instance == instance1);
    }

    @Test
    public void save() throws IOException {
        InnerSingleton instance = InnerSingleton.getInstance();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("InnerSingleton"));
        out.writeObject(instance);
        out.close();
    }

    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("InnerSingleton"));
        InnerSingleton innerSingleton = (InnerSingleton) in.readObject();
        in.close();
        Assert.assertEquals(true, InnerSingleton.getInstance() == innerSingleton);
    }
}
