package com.itcast;

import java.util.Date;

/**
 * @author LiYang
 * @Project Name: JavaWebDemo
 * @Package Name: com.itcast
 * Created by MacBook Air on 2020/05/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
class Student{
    int age;
    double score;
    String time;

    public Student() {

    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int age, double score, String time) {
        this.age = age;
        this.score = score;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", score=" + score +
                ", time=" + time +
                '}';
    }
}
