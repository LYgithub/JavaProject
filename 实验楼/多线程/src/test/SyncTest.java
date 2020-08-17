package test;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: test
 * Created by MacBook Air on 2020/02/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class SyncTest {
    public static void main(String[] args) {


    }
}

class Sync {
    private int index;
    private char []sync;
    public Sync(int index) {
        this.index = index;
        sync = new char[100];
    }

    public synchronized char pop(){

        Object x = null;
        return (char) x;
    }
    public synchronized void push(){

    }
}
