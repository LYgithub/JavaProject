package javatest;


/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/02/01.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class String_1 {
    public static void main(String[] args) {
        System.out.println("开始测试...");
        test();

        System.out.println("finish");
    }
    /**
     *
     * @param m
     * @param n
     * @return
     */
    public static int gys(int m,int n){
        if(m<n){
            int temp = m;m = n; n = temp;
        }
        int t ;
        do{
            t = m%n;
            m = n;
            n = t;
        }while(t!=0);
        return m;
    }
    public static void test(){
        int i = 1000;
        for (int ix = 1; ix < i; ix++) {
            System.out.println(ix+"测试中。。。");
            for (int j = 1;j<i;j++){
                if(gys(ix,j) != gys(j,ix)){
                    System.out.println(ix+"与"+j+"的最大公约数为："+gys(ix,j));
                    System.out.println(j+"与"+ix+"的最大公约数为："+gys(ix,j));
                }

            }
        }
    }
}
