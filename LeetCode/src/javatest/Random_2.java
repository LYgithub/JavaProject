package javatest;

import java.util.Random;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/02/02.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class Random_2 {
    public static void main(String[] args) {
        //两个不同的random对象对于相同的种子，生成的随机数是相同的
        try{

            Random random1 = new Random(1);
            Random random2 = new Random(1);
            for (int i = 0; i < 10; i++) {
                System.out.print(random1.nextInt(10)+"\t");
            }
            System.out.println();
            Thread.sleep(1000);
            for (int i = 0; i < 10; i++) {
                System.out.print(random2.nextInt(10)+"\t");
            }
            System.out.println();

        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
