package com.company;

public class Demooverride{
    public static void main(String[] args) {
        System.out.println("hello");
        Person p = new Student();
        p.printf();
        p.printf1();
        p = new Person();
        p.printf();
        System.out.println(p instanceof Person);
        System.out.println(p instanceof Student);
    }
}

class Person{
    public void printf(){
        System.out.println("I am Person!");
    }
    public void printf1(){
        System.out.println("I am Person!");
    }

}

class Student extends Person{

    @Override
    public void printf(){
        System.out.println("I am Sturdent!");
    }
}