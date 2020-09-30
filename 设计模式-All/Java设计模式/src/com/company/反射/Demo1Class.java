package com.company.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo1Class{
    public static void main(String[] args) throws Exception{
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    /**
     * Class 的三种构造方法
     */
    public static void test1() throws Exception{
        //对象创建
        Class clazz = new Teacher().getClass();
        System.out.println(clazz);

        // 类名常见
        clazz = Teacher.class;
        System.out.println(clazz);

        //全名创建， 存在异常 ClassNotFoundException
        try{
            clazz = Class.forName("com.company.反射.Teacher");
            System.out.println(clazz);
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("===========-----------------");



        //调用方法 invoke(obj, 参数)
        Method m = clazz.getMethod("faceFunction");
        //接触封装
        m.setAccessible(true);
        m.invoke(new Teacher());
        /* 有返回值方法 */
        String s = (String) m.invoke(new Teacher());
        System.out.println("*********************");

    }

    public static void test2(){
        Class clazz = new Teacher().getClass();
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getInterfaces());
        System.out.println(clazz.getConstructors());

        /**
         * 获取所有的共有的构造方法
         */
        Constructor[] con = clazz.getConstructors();
        for(Constructor c : con){
            System.out.println(c.getName()+"\t修饰符为：" + c.getModifiers());
        }
        System.out.println("===========-----------------");

        /**
         * 获取所有的构造方法
         * getModifiers 获取修饰符
         *      1： 共有
         *      2： 私有
         */
        Constructor[] cons = clazz.getDeclaredConstructors();
        for(Constructor c : cons){
            System.out.println("方法名称："+c.getName() + "\t修饰符为：" + c.getModifiers());
            //获取参数类型
            Class [] classes = c.getParameterTypes();
            for(Class cl : classes){
                System.out.println(cl.getName());
            }
            System.out.println("----------------------------------");
        }

    }


    /**
     * 使用反射的构造方法创建对象
     */
    public static void test3(){
        Class clazz = new Teacher().getClass();
        try {

            //调用无参构造
            Object obj = clazz.newInstance();
            Teacher p = (Teacher) obj;
            System.out.println(p.toString());

            //调用有参构造
            Constructor con = clazz.getConstructor(int.class, String.class);
            Teacher p1 = (Teacher) con.newInstance(3, "x");
            p1.faceFunction();

            // 强制私有构造
            Constructor con2 = clazz.getDeclaredConstructor(int.class);
            //基础封装
            con2.setAccessible(true);
            Teacher p2 = (Teacher) con2.newInstance(2);
            p2.faceFunction();


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("===============");
        }

    }


    /**
     * 获取方法
     */
    public static void test4(){
        Class clazz = new Teacher().getClass();
        Method [] methods = clazz.getMethods();

        for(Method m : methods){
            System.out.println(
                    /*获取返回值类型*/
                    m.getReturnType() + "\t"
                            /*获取名字*/
                            + m.getName() + "\t"
                            /*获取参数 返回Class 数组 (同test3)*/
                            + m.getParameterTypes() + "\t"
                            /*获取修饰符*/
                            + m.getModifiers());

        }
        System.out.println("-----------------------");
        //获取共有的
        methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            System.out.println(
                    /*获取返回值类型*/
                    m.getReturnType() + "\t"
                            /*获取名字*/
                            + m.getName() + "\t"
                            /*获取参数 返回Class 数组 (同test3)*/
                            + m.getParameterTypes() + "\t"
                            /*获取修饰符*/
                            + m.getModifiers());

        }

        System.out.println("======================");
    }

    /**
     * 获取属性
     */
    public static void test5() throws Exception{
        Class clazz = new Teacher().getClass();
        Field [] fields = clazz.getDeclaredFields();
        for (Field f : fields){
            System.out.print(f.getModifiers()+"\t");
            System.out.print(f.getType()+"\t");
            System.out.println(f.getName());

        }
        System.out.println(clazz.getPackage());


        //先创建一个对象
        Constructor con = clazz.getConstructor();
        Teacher t = (Teacher) con.newInstance();
        // 获取属性
        Field f = clazz.getDeclaredField("name2");
        //解除私有封装 暴力反射
        f.setAccessible(true);
        System.out.println(f.get(t));
        f.set(t, "name");
        System.out.println((String) f.get(t));
    }

}

