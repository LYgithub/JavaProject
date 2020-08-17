package com.company;

public class DemoObject {
    public static void main(String[] args) {
        printf(1);
        
        printf("1");
        printf(new Demooverride());
        DemoObject x = new DemoObject();
        DemoObject y = new DemoObject();
        y = x;

        /**
         * equals 判断是否为同一个对象
         */
        String s = "Hello";
        String s2 = "Hello";
        System.out.println(s.equals(s2));
        System.out.println(x.equals(y));

        String s3 = new String("Hello");
        System.out.println(s.equals(s3));
        int number = 1;
        System.out.println(s.equals(number));
        System.out.println(s.hashCode());
    }

    public static void printf(Object o){
        System.out.println(o.getClass());
    }
}