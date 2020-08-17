package javatest;

import java.util.Random;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/02/02.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class Random_1 {
    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        for (long  i = 0; i < 1000000000; i++) {
            if(random.nextBoolean() == false){
                sum ++;
            }
        }
        System.out.println(sum / 1000000000.0);
    }
    public static void test(){
        Random random = new Random();
        int j = 10;
        for (int i = 0; i < j; i++) {
            System.out.print(random.nextInt()+"  ");
        }
        System.out.println("\n");
        for (int i = 0; i < j; i++) {
            System.out.print(random.nextLong()+"  ");
        }
        System.out.println("\n");
        for (int i = 0; i < j; i++) {
            System.out.print(random.nextBoolean()+"  ");
        }
    }
}
