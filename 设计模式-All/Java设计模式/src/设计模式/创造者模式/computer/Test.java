package 设计模式.创造者模式.computer;


/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.computer
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    @org.junit.Test
    public void test1(){
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);
        Computer construct = director.construct("主板", "Inter");
        System.out.println(construct.toString());

        builder = new HonerComputerBuilder();
        director = new Director(builder);
        Computer computer = director.construct("主板CN", "Inter");
        System.out.println(computer.toString());

    }
}
