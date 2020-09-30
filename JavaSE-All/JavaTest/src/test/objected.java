package test;


/**
 * @author LiYang
 * @Project Name: JavaTest
 * @Package Name: test
 * Created by MacBook Air on 2020/02/13.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class objected {
    public static void main(String[] args) {
        Person person1 = new Person(110,20,true);
        Person person2 = new Person(120,21,true);
        System.out.println(person1.comperTo(person2));
        System.out.println(person1.equals(person2));
    }



}

class Person{
    int tall,age;
    boolean gender;
    Person(int tall,int age,boolean gender){
        this.tall = tall;
        this.age = age;
        this.gender = gender;
    }
    Person(){
        this(120,20,true);
    }
    //重写 Object 中的 equals 函数
    public boolean equals(Object b){
        return tall == ((Person)b).tall;
    }
    //重写 Object 中的 comperTo 函数
    public int comperTo(Object b){
        return age - ((Person)b).age;
    }
}