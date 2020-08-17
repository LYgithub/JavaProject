
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */

/**
 * ThreadDemo1 采用ThreadLocal(线程变量)的方式创建integer变量
 * ThreadDemo2 采用类变量的方式创建integer变量
 * Lock 并不能解决两个线程运行前后问题
 * @author Mac
 */

public class ThreadLocalDemoPro {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        lock.lock();
        try{
            new Thread(threadDemo2).start();
        }finally {
            lock.unlock();
            System.out.println("解锁前integer = "+threadDemo2.getInteger());
        }
        System.out.println("-----------");

        lock.lock();
        try{
            System.out.println("第二次加锁后integer = "+threadDemo2.getInteger());
            threadDemo2.setInteger(0);
            new Thread(threadDemo2).start();
        }finally {
            lock.unlock();
        }
    }

}


