/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 * 
 * run() 方法：线程需要运行的代码逻辑
 * start() 方法：启动线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.run();
        thread1.start();
        Thread thread = new Thread(new Thread2());
        thread.run();
        thread.start();

    }
}

class Thread1 extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread "+i);
        }
    }
}

class Thread2 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Runnable "+i);
        }
    }
}