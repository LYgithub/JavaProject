package javatest;

import java.util.Scanner;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/01/30.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class input {
    public static void main(String[] args) {
        //输入测试
        Scanner reader = new Scanner(System.in);
        double x = reader.nextDouble();
        double y = reader.nextDouble();
        System.out.println(x + y);
        System.out.println(x);


        char a = 'A';
        System.out.println(a);
        a = 97;
        System.out.println(a);
        //reader.next()  读取一个单词 ，charAt 是第几个字符，字从0 开始编号
        a = reader.next().charAt(3);
        System.out.println(a);
        //char 强制转换成int 会输出该char字符的ASCII码
        System.out.println(a + (int)a);

    }
}
