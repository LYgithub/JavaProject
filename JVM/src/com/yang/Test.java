package com.yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: JVM
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/09/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    private static byte[] bytes = new byte[1024*100];
    public static void main(String[] args) throws InterruptedException {
        List<Test> list = new ArrayList<>();
        while (true){
            list.add(new Test());
            Thread.sleep(10);
        }
    }
}
