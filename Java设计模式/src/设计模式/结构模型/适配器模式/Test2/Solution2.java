package 设计模式.结构模型.适配器模式.Test2;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.结构模型.适配器模式
 * Created by MacBook Air on 2020/07/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution2 {
    public static void main(String[] args) {
        Adapte adapte = new Adapte();
        adapte.output5V();
        /** 违反了最少知道原则 */
        adapte.output220V();
    }
}


/** Class Adapter */
class Adaptee{
    public int output220V(){
        return 220;
    }
}
interface Target{
    int output5V();
}

class Adapte extends Adaptee implements Target {

    @Override
    public int output5V() {
        int v = output220V();
        System.out.println(String.format("原始电压：%d V -> 转换后：%d V",v,5));
        return 5;
    }
}


