package com.company.反射;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.反射
 * Created by MacBook Air on 2020/05/19.
 * Copyright © 2020 LiYang. All rights reserved.
 * https://www.bilibili.com/video/BV1CJ411m7gg?p=120
 */

class Person {
    public int age;
    private String name;

    public String getName() {
        return name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private Person(int age) {
        this.age = age;
    }

    public Person() {    }
}

class Teacher extends Person implements myInterface{

    public String name3;
    private String name2;

    public Teacher(int age, String name) {
        super(age, name);
        System.out.println("有参共有构造！");
    }

    private Teacher(int age){}

    public Teacher() {
        System.out.println("无参共有构造！");
    }

    @Override
    public void faceFunction() {
        System.out.println("myInterface!" + super.getName() +"\t" + this.age);
    }
    @Override
    public String getName(){
        return super.getName();
    }

    private int getAge(){
        return this.age;
    }
}

class TeacherSon extends Teacher{
    public TeacherSon(int age, String name) {
        super(age, name);
    }

    public TeacherSon(){}

}

interface myInterface{
    void faceFunction();
}