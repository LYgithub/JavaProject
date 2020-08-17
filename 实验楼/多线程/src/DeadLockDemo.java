/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class DeadLockDemo {
    /**
     * 线程1 先需要获取lockA 后需要获取lockB
     * 线程2 先需要获取lockA 后需要获取lockB
     * 当两个进程共同运行时，线程1 获取了lockA ,线程2 获取了lockB
     * 造成两个线程相互等待对方占有资源的情况
     * 造成死锁
     */
    private static Object lockA = new Object();
    private static Object lockB = new Object();

    public static void main(String[] args) {
        //这里使用lambda表达式创建了一个线程
        //线程  1
        new Thread(() -> {
            synchronized (lockA) {
                try {
                    //线程休眠一段时间  确保另外一个线程可以获取到b锁
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("D");
                synchronized (lockB) {
                }
            }
        }).start();
        //线程 2
        new Thread(() -> {
            synchronized (lockB) {
                System.out.println("死锁...");
                synchronized (lockA) {
                }
            }
        }).start();
    }
}