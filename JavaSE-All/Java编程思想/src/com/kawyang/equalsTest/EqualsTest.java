package com.kawyang.equalsTest;

import java.sql.SQLOutput;
import java.util.Objects;

/**
 * @author LiYang
 * @Project Name: Java编程思想
 * @Package Name: com.kawyang.equalsTest
 * Created by MacBook Air on 2020/08/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class EqualsTest {
    public static void main(String[] args) {
        Dog dog = new Dog("spot","Ruff!");
        Dog dog1 = new Dog("scruffy","Wurf!");
        System.out.println(dog.equals(dog1));
        System.out.println(dog == dog1);
        dog1 = dog;
        System.out.println(dog.equals(dog1));
        System.out.println(dog == dog1);

        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = 10; v2.i = 10;
        System.out.println("v1.equals(v2) = " + v1.equals(v2));

        Integer i1 = new Integer(10);
        Integer i2 = new Integer(10);
        System.out.println("i1.equals(i2) = " + i1.equals(i2));

    }
}
class Dog{
    String name;
    String says;

    public Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", says='" + says + '\'' +
                '}';
    }
}


class Value{
    int i;
}
