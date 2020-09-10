package com.yang.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author LiYang
 * @Package Name: com.yang.thread
 * @Project Name: Java-SE
 * Created by MacBook Air on 2020/09/08.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ThreadLocalDemo {

    public static final ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static void main(String[] args) {
        // 同一个任务两个线程执行
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        thread.start();
        new Thread(myThread).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getState().toString());
        thread.start();
    }

    /**
     * 给每个线程创建一个副本
     */
    static class MyThread implements Runnable{
        @Override
        public void run() {
            // get
            Long aLong = threadLocal.get();
            synchronized (this){
                if(aLong == null ){
                    // set
                    threadLocal.set(System.currentTimeMillis());
                    System.out.println(Thread.currentThread().getName() +":" + threadLocal.get());
                }
            }
        }
    }

}




