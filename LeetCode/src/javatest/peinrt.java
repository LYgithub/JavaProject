package javatest;


/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/01/31.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class peinrt {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = "ABC";
        String s4 = new String("abc");
        System.out.println("s1.compareTo(s2):"+s1.compareTo(s2));
        System.out.println("s1.compareToIgnoreCase(s3):"+s1.compareToIgnoreCase(s3));
        //比较的是地址啊
        System.out.println("s1 == s2:"+ (s1 == s2));
        //比较的是内容
        System.out.println("s1.equals(s2):"+ s1.equals(s2));
        //忽略大小写比较
        System.out.println("s1.equalsIgnoreCase(s3):"+s1.equalsIgnoreCase(s3));
        System.out.println("s1 == s4:"+(s1 == s4));
        System.out.println("s1.equals(s4):"+s1.equals(s4));

        System.out.println("Hello World".substring(0,4));
    }
}
