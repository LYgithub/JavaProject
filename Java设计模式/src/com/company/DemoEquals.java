package com.company;


public class DemoEquals{
    public static void main(String[] args) {
        String s2 = new String("abc");
        String s1 = "abc";
        String s3 = new String("abc");
        System.out.println(s1.equals(s2));
        System.out.println(s1 == s2);
        System.out.println(s2 == s3); 

        s2 = new String("abc1");
        s3 = new String("abc1");
        System.out.println(s2.equals(s3));

    }
}