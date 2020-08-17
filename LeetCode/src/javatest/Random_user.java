package javatest;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/02/04.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class Random_user {
    public static void main(String[] args) {
        int n = 52;
        String huase [] = {"♥️","♦️","♣️","♠️"};
        String daxiao []={"2 ","3 ","4 ","5 ","6 ","7 ","8 ","9 ","10","J ","Q ","K ","A "};
        int puke[] = new int[n];
        double xipai[] = new double[n];
        for (int i = 0; i < n; i++) {
            puke[i] = i;
            xipai[i] = Math.random();
        }
        printf(huase, daxiao, puke);
        //洗牌
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (xipai[j]<xipai[min]) {
                    min = j;
                }
            }
            if(i != min){
                int temp = puke[i];puke[i] = puke[min];puke[min] = temp;
                double temp2 = xipai[i];xipai[i] = xipai[min];xipai[min]=temp2;
            }
        }
        System.out.println("----------------------------------------------------------------");
        printf( huase, daxiao, puke);
        System.out.println();
    }

    private static void printf(String[] huase, String[] daxiao, int[] puke) {
        for (int i = 0; i < puke.length; i++) {
            System.out.print(huase[puke[i]/13] + daxiao[puke[i]%13] + " ");
            if ((i+1) % 13 == 0) {
                System.out.println();
            }
        }
    }
}
