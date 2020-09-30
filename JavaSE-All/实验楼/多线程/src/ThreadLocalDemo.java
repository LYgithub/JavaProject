/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/16.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * ThreadDemo1 采用ThreadLocal(线程变量)的方式创建integer变量
 * ThreadDemo2 采用类变量的方式创建integer变量
 * @author LiYang
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        test();
        System.out.println("===========");
        test2();
    }

    /**
     * 不同对象，创建两个线程
     * 测试结果:每个线程变量互不影响，都相对独立。
     * 因为是四个不同的ThreadDemo对象分别创建的线程，称不上是多线程。
     * 相等于创建了四个不同的类对象
     */
    public static void test(){
        new Thread(new ThreadDemo1()).start();
        new Thread(new ThreadDemo1()).start();
        System.out.println("1----------");
        new Thread(new ThreadDemo2()).start();
        new Thread(new ThreadDemo2()).start();
    }


    /**
     * 同一个对象，创建两个线程。
     * ThreadDemo1 采用ThreadLocal变量，两个线程互不影响，变量相对独立
     * ThreadDemo2 采用类变量方式，对于同一个Thread对象，两个线程之间变量相互影响
     * 同一个对象，共享资源，在多线程中容易发生错误。
     */
    public static void test2(){
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        new Thread(threadDemo1).start();
        new Thread(threadDemo1).start();
        System.out.println("2-----------");
        ThreadDemo2 threadDemo2 = new ThreadDemo2();
        new Thread(threadDemo2).start();
        new Thread(threadDemo2).start();
    }
}

class ThreadDemo1 implements Runnable{
    /**使用ThreadLocal提供的静态方法创建一个线程变量 并且初始化值为0*/
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            //get方法获取线程变量值
            Integer integer = threadLocal.get();
            integer += 1;
            //set方法设置线程变量值
            threadLocal.set(integer);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(integer);
        }
    }
}

class ThreadDemo2 implements Runnable{
    private Integer integer = 0;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            integer++;
            System.out.println("Thread2 "+integer);
        }
    }
}