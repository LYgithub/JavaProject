/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadState threadState = new ThreadState();
        Thread thread = new Thread(threadState);
        System.out.println("创建新的进程：" + thread.getState()+" "+thread.getName());
        thread.start();
        System.out.println("启动进程："+thread.getState());
        Thread.sleep(100);
        System.out.println("等待一会："+thread.getState());
        Thread.sleep(1000);
        System.out.println("永久等待："+thread.getState());
        threadState.notifyNow();
        System.out.println("阻塞线程："+thread.getState());
        Thread.sleep(200);
        System.out.println("已终止："+thread.getState());
    }
}

class ThreadState implements Runnable {

    public synchronized void waitForAMoment() throws InterruptedException {
        wait(500);
    }

    public synchronized void waitForever() throws InterruptedException{
        wait();
    }

    public synchronized void notifyNow() {
        notify();
    }
    @Override
    public void run() {

        try{
            waitForAMoment();

            waitForever();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
