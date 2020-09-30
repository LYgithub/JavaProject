package com.yang.string;

/**
 * @author LiYang
 * @Project Name: Java-SE
 * @Package Name: com.yang.string
 * Created by MacBook Air on 2020/09/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class StringTest {
    public static void main(String[] args) {
        String s1 = new String("zs");
        String s2 = new String("zs");
        System.out.println(s1 == s2);/// false
        String s3 = "zs";
        String s4 = "zs";
        System.out.println(s3 == s4);/// true
        System.out.println(s3 == s1);/// false
        String s5 = "zszs";
        String s6 = s3+s4;
        System.out.println(s5 == s6);/// fales
        final String s7 = "zs";
        final String s8 = "zs";
        String s9 = s7+s8;
        System.out.println(s5 == s9);/// true
        final String s10 = s3+s4;
        System.out.println(s5 == s10);/// false
    }
}
