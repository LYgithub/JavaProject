package 设计模式.结构模型.外观模式;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.结构模型.外观模式
 * Created by MacBook Air on 2020/07/19.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    public static void main(String[] args) {
        SubSystemFacade subSystemFacade = new SubSystemFacade();
        subSystemFacade.PrintSub1();
        subSystemFacade.PrintSub2();
        subSystemFacade.PrintSub3();
    }
}

class SubSystemFacade{
    SubSystem1 subSystem1;
    SubSystem2 subSystem2;
    SubSystem3 subSystem3;

    public SubSystemFacade() {
        this.subSystem1 = new SubSystem1();
        this.subSystem2 = new SubSystem2();
        this.subSystem3 = new SubSystem3();
    }

    public void PrintSub1(){
        subSystem1.print();
    }
    public void PrintSub2(){
        subSystem2.print();
    }
    public void PrintSub3(){
        subSystem3.print();
    }
}

interface ISubSystem{
    public void print();
}

class SubSystem1 implements ISubSystem{
    @Override
    public void print(){
        System.out.println("SubSystem1!");
    }
}
class SubSystem2 implements ISubSystem{
    @Override
    public void print(){
        System.out.println("SubSystem2!");
    }
}
class SubSystem3 implements ISubSystem{
    @Override
    public void print(){
        System.out.println("SubSystem3!");
    }
}
