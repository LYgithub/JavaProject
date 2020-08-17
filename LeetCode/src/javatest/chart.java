package javatest;

import java.util.Scanner;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/01/30.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class chart {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        char x = reader.next().charAt(0);
        System.out.println(x - 'a' + 1);

        //switch 多分支语句
        //整数、字符、字符串（实数是约等于运算，不包括）
        //不适合区间
        switch (x){
            case 'a':
            case 'c':
            case 'd':
                System.out.println("hello world");break;
            case 'b':
                System.out.println('b');break;
            default:
                System.out.println("Hello" + x);break;
        }
    }
}
