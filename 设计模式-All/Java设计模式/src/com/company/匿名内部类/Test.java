package com.company.匿名内部类;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.匿名内部类
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 创建一个匿名 Person子类，不能使用 new 来调用构造器
         */
        Person p  = new Person(){
            { //在匿名内部类中使用代码块代替构造器
                super.ID = "12";
            }

            @Override
            public void test() {
                super.test();
                System.out.println(this.ID);
            }
        };

        p.test();
    }
}
