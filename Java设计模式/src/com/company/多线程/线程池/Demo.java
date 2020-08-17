package com.company.多线程.线程池;

import java.util.concurrent.*;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.多线程.线程池
 * Created by MacBook Air on 2020/05/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Demo {
    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                //一次执行的线程数
                3,
                3,
                60,
                TimeUnit.SECONDS,
                //阻塞队列
                new ArrayBlockingQueue<Runnable>(21),
                Executors.defaultThreadFactory());
        for(int i =0; i<10; i++){
            poolExecutor.execute(new Task(i));
        }

        poolExecutor.shutdown();//提交的任务仍然执行
//        poolExecutor.shutdownNow();//提交的任务拒绝执行
    }
}

class Task implements Runnable{
    private int nov ;

    public Task(int nov) {
        this.nov = nov;
    }

    @Override
    public void run(){
        try {
            Thread.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行当前任务的线程是："+ Thread.currentThread().getName());
        System.out.println("我是任务："+ nov);
    }
}