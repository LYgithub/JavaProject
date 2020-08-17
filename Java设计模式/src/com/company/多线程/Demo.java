package com.company.多线程;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.多线程
 * Created by MacBook Air on 2020/05/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        thread1.start();
        thread2.start();
    }
}

class MyThread extends Thread{
    @Override
     public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
        }
        System.out.println("-----------");
        synchronized (this)
        {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + ":\t" + i);
                try {
                    Thread.sleep(2L);
                } catch  (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
