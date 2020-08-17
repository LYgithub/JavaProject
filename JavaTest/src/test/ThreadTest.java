package test;

import java.util.Objects;

/**
 * @author LiYang
 * @Project Name: JavaTest
 * @Package Name: test
 * Created by MacBook Air on 2020/02/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.start();
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        String s1 = "";
        String s2 = "test";
        boolean equals = Objects.equals(s1, s2);
        System.out.println(equals);

    }
}

//通过继承Thread类，创建MyThread对象实现进程
class MyThread extends Thread{
    public void run(){
        for(int i = 0;i<10;i++){
            System.out.println("MyThread Run!"+i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

//
class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunnable Run!"+i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}