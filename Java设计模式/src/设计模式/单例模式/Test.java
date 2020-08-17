package 设计模式.单例模式;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: 设计模式.单例模式
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * 饿汉式单例模式  Single.java
 * 懒汉式单例模式  Single1.java
 */
public class Test {
    public static void main(String[] args) {
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();
        Single.getInstance();

        Single1.getInstance();
        Single1.getInstance();
        Single1.getInstance();
        Single1.getInstance();
    }
}
