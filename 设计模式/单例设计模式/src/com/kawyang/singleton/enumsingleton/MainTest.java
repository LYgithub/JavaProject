package com.kawyang.singleton.enumsingleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: 设计模式
 * @Package Name: com.kawyang.Enum
 * Created by MacBook Air on 2020/07/09.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MainTest {
    @Test
    public void test1(){
        EnumSingleton instance = EnumSingleton.INSTANCE;
        EnumSingleton instance1 = EnumSingleton.INSTANCE;
        Assert.assertEquals(true, instance == instance1);
    }
    @Test
    public void save() throws IOException {

        EnumSingleton instance = EnumSingleton.INSTANCE;
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("EnumSingleton"));
        out.writeObject(instance);
        out.close();
    }

    @Test
    public void read() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(n
                ew FileInputStream("EnumSingleton"));
        EnumSingleton innerSingleton = (EnumSingleton) in.readObject();
        in.close();
        Assert.assertEquals(true, EnumSingleton.INSTANCE == innerSingleton);
    }
}
