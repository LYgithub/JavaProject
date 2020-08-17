package javatest;

import java.util.Scanner;

/**
 * @author Mac
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/01/30.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class HuiWen {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int a = reader.nextInt();
        System.out.println(Change(a));
        if(a == Change(a)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
        GoTo();
        number();
    }

    /**
     * 求一个多位数的逆序数
     * ❓：该数不能 0 开头和结尾
     * @param x
     * @return 逆序数
     */
    public static int Change(int x){
        //存放反转后的数字
        int n = 0 ;
        do{
            n = n*10 + x%10;
            x /= 10;
        }while (x!=0);
        return n;
    }

    /**
     * 跳转指令
     */
    public static void GoTo(){

        outer:
        for (int j = 0; j < 10 ; j++) {
            for (int i = 0; i < 10; i++) {
                for (int px = 1; px < 10; px++) {
                    if (i > 5) {
                        System.out.println(j + " " + i);
                        continue outer;
                    }
                }
            }
        }
    }

    /**
     * 计算1000 以内10个最大质数平均值
     */
    public static void number(){
        int sum =0,i = 0;
        for(int j = 1000;j>2;j--){
            for(int x = 2;x<j/2;x++){
                if(j%x == 0){
                    break;
                }
            }

            i++;
            sum += j;

            if(i<10){
                //1 - 9 9个数
                System.out.print(j + "+");
            }else{
                //第 10 个数
                System.out.println(j +"="+sum);
                break;
            }
        }
    }
}

