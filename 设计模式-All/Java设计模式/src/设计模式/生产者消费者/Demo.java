package 设计模式.生产者消费者;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: 设计模式.生产者消费者
 * Created by MacBook Air on 2020/05/20.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class Demo {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        //生产者 : 生产时不消费，消费时不生产
        new Thread(() -> {
            synchronized (clerk){
                //无限生产
                while (true){
                    if(clerk.productNum ==0 ){
                        System.out.println("产品为0，开始生产");
                        while (clerk.productNum < 4){
                            System.out.println("库存：" + clerk.productNum);
                            clerk.productNum++;
                        }
                        System.out.println("产品数为:"+clerk.productNum+"生产结束！");
                        clerk.notify();//唤醒消费者
                    }else{
                        try {
                            clerk.wait();//让生产者等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"生产者").start();

        //消费者
        new Thread(() -> {
            synchronized (clerk){
                while (true){
                    if(clerk.productNum == 4){
                        System.out.println("产品数为4 , 开始消费！");
                        while (clerk.productNum > 0){
                            System.out.println("消费，库存："+clerk.productNum);
                            clerk.productNum--;
                        }
                        clerk.notify();//唤醒生产者
                    }else {
                        try {
                            clerk.wait();//消费者等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        },"消费者").start();
    }
}
