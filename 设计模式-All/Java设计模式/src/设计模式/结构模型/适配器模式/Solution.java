package 设计模式.结构模型.适配器模式;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.结构模型.适配器模式
 * Created by MacBook Air on 2020/07/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    public static void main(String[] args) {
        Adapte adapte = new Adapte();
        System.out.println(adapte.output5V());
    }
}

/** Object Adapter */
class Adaptee{
    public int output220V(){
        return 220;
    }
}

interface Target{
    int output5V();
}

class Adapte implements Target{
    Adaptee adaptee ;

    public Adapte() {
        this.adaptee = new Adaptee();
    }

    @Override
    public int output5V() {
        int v = adaptee.output220V();
        System.out.println(String.format("原始电压：%d V -> 转换后：%d V",v,5));
        return 5;
    }
}
