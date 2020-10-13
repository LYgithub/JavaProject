package com.company;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author yang
 * 反射： 运行时动态的获取 类的所有内容；
 */
public class Main {

    static int [] arr = new int[10];
    public static void main(String[] args) throws Exception {
	    // 1. 获取 Class 的三种方式
        Class<Test> testClass = Test.class;
        Class<? extends Test> aClass = new Test().getClass();
        Class<?> aClass1 = Class.forName("com.company.Test");

        // 2. 获取 构造函数
        Constructor<Test> constructor = testClass.getConstructor();
        Test test = constructor.newInstance();
        test.print();

        Constructor<Test> constructor1 = testClass.getConstructor(int.class, String.class);
        constructor1.newInstance(3,"KawYang").print();

        //3. 获取 方法
        Method print = testClass.getMethod("print");
        System.out.println(print.getName());
        System.out.println(print.getReturnType());

        Method selfPrint = testClass.getDeclaredMethod("selfPrint", String.class);
        selfPrint.setAccessible(true);
        Object ret = selfPrint.invoke(test, "args");
        System.out.println(ret);

        // 4. 获取元素
        Field id = testClass.getField("id");
        id.set(test, 122);
        System.out.println(id.get(test));

        // 5. 获取权限
        Field name = testClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(test, "...");
        test.print();


    }
}
