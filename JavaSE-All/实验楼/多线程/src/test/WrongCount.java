package test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: test
 * Created by MacBook Air on 2020/02/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class WrongCount {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Count count = new Count(0);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest(count," "));
            thread.start();
            //System.out.println(thread.getName() + ":" + count.getCount());
        }
    }
}

class Count{
    static int count;

    public Count(int count) {
        Count.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        Count.count = count;
    }
}

class ThreadTest implements Runnable{

    final Count number;

    String threadName;
    ThreadTest(Count number,String str) {
        this.number = number;
        this.threadName = str;
    }

    @Override
    public void run() {
        WrongCount.lock.lock();
        try{
            int count = number.getCount();
            Thread.sleep(0);
            number.setCount(count+1);
            System.out.println(number.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            WrongCount.lock.unlock();
        }
    }
}