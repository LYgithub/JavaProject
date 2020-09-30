package com.company.注解;

import java.lang.annotation.*;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.注解
 * Created by MacBook Air on 2020/05/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@SuppressWarnings({"unused"}) //抑制编译器警告
public class DemoMyAnnotation implements MyInterface{

    /**
     * 自定义注解
     */
    @TestAnn(id = 100, desc = "姓名")
    String name;

    /**
     * 父类方法重写
     */
    @Override
    public void test(int... args) {
        System.out.println("Interface!");
        System.out.println(args.toString());

        for( Object obj : args){
            System.out.println(obj);
        }
    }

    public static void main(String[] args) {
        new DemoMyAnnotation().test(1, 2, 3);

        /**
         * 使用 lambda实现 含有一个方法的接口
         */
        MyInterface myInterface = (ints) -> System.out.println("test - interface - lambda \n" + args.getClass());
        myInterface.test(1,3,4 );
    }
}

/**
 * @author LiYang
 * 自定义注解
 */
@Target(ElementType.FIELD)// 给其他类的属性做注解（指定注解的内容）
@Retention(RetentionPolicy.RUNTIME)// 定义注解的生命周期
@Documented //写入到文档中
@interface TestAnn{
    public int id() default 0;
    public String desc() default "";

}


interface MyInterface{
    /**
     * 过时注解
     * @param args 参数
     */
    @Deprecated
    void test(int... args);
}