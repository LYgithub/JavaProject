package 设计模式.行为模式.观察者模式;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.行为模式.观察者模式
 * Created by MacBook Air on 2020/07/21.
 * Copyright © 2020 LiYang. All rights reserved.
 *
 * 符合开闭原则
 * 在运行时建立对象之间的关系
 */
public class Solution {
    @Test
    public void test1(){
        Subject subject = new Subject();
        subject.add(new Task1());
        Task2 task2 = new Task2();
        subject.add(task2);

        // 事件发生
        subject.notifyObserver("通知1");
        System.out.println("-----------");
        // 移除观察者
        subject.remove(task2);
        subject.notifyObserver("通知2:1");
    }
}

class Subject {
    List<Observer> list = new ArrayList<>();

    public void add(Observer observer){
        list.add(observer);
    }
    public void remove(Observer observer){
        list.remove(observer);
    }

    /**
     * 通知每一个观察者
     * @param object
     */
    public void notifyObserver(Object object){
        for (Observer item :
                list) {
            item.update(object);
        }
    }
}

interface Observer{
    void update(Object object);
}

class Task1 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task1:" + object.toString());
    }
}

class Task2 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task2:" + object.toString());
    }
}