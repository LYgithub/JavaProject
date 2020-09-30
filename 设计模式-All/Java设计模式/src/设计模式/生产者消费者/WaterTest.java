package 设计模式.生产者消费者;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.生产者消费者
 * Created by MacBook Air on 2020/07/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class WaterTest {
    public static void main(String[] args) {
        Water water = new Water();
        ThreadA threadA = new ThreadA(water);
        ThreadB threadB = new ThreadB(water);
        threadB.start();
        threadA.start();
    }
}

class ThreadA extends Thread{

    Water water;
    public ThreadA(Water water){
        this.water = water;
    }

    @Override
    public void run() {
        System.out.println("开始进水...");
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                System.out.println(i + "分钟！");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        water.setWater(true);
        System.out.println("进水完毕");
        synchronized (water){
            water.notify();
        }
    }
}

class ThreadB extends Thread{
    Water water;
    public ThreadB(Water water){
        this.water = water;
    }

    @Override
    public void run(){
        System.out.println("启动排水");
        if(water.isEmpty()){
            synchronized (water){
                try{
                    System.out.println("水塘无水，等待...");
                    water.wait();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("start排水");
        for (int i = 0; i < 5; i++) {
            try{
                Thread.sleep(100);
                System.out.println(i+"min");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        water.setWater(false);
        System.out.println("finished！");
    }

}
class Water{

    boolean water = false;
    public void setWater(boolean b) {
        water = b;
    }

    public boolean isEmpty() {
        return !this.water;
    }
}
