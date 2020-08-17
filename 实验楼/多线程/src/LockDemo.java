import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */

public class LockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            lock.lock();
            try {
                //需要同步的代码块
                System.out.println("线程1加锁");
                Thread.sleep(50000);
            }catch (InterruptedException e){
                System.out.println(e);
            }finally {
//                一定要在finally中解锁，否则可能造成死锁
                lock.unlock();
                System.out.println("线程1解锁");
            }
        });

        thread1.start();
        Thread thread2 = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("线程2加锁");
            }finally {
                lock.unlock();
                System.out.println("线程2解锁");
            }
        });

        thread2.start();
    }

}