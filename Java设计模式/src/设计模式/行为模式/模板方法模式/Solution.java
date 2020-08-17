package 设计模式.行为模式.模板方法模式;

import org.junit.Test;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.行为模式.模板方法模式
 * Created by MacBook Air on 2020/07/21.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    @Test
    public void test(){
        // 使用 里氏代换原则 完成超类中框架的调用
        AbstractClass abstractClass = new SubClass();
        abstractClass.operation();
    }
}

abstract class AbstractClass{
    public void operation(){
        //骨架
        System.out.println("pre..");
        System.out.println("tep1...");

        templateMethod();
    }

    /**
     * 定义抽象方法，具体实现由子类完成
     */
    abstract protected void templateMethod();
}

class SubClass extends  AbstractClass{

    /**
     * 具体的实现由 子类完成。
     * 调用是由父类完成的。
     */
    @Override
    protected void templateMethod() {
        System.out.println("子类的方法！");
    }
}