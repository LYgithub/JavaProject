package javatest;

/**
 * @author Mac
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/01/30.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class MaxinThree {
    public static void main(String[] args) {
        System.out.println(max1(3, 1, 2));
        System.out.println(max2(3, 1, 2));
        System.out.println(max3(3, 1, 2));
    }

    /**
     * 方法复杂，可拓展性低。
     * @param a
     * @param b
     * @param c
     * @return max
     */
    public static int max1(int a ,int b ,int c){
        if(a>b) {
            if (a > c) {
                return a;
            } else {
                return c;
            }
        }else{
            if(b > c){
                return b;
            }else {
                return c;
            }
        }
    }

    /**
     * 方法简单
     * @param a
     * @param b
     * @param c
     * @return  max
     */
    public static int max2(int a ,int b ,int c){
        if(a>b&& a>c){
            return a;
        }else if(b>c){
            return b;
        }else{
            return c;
        }
    }

    /**
     * 方法简单，可拓展性高
     * 运用选择排序的思想
     * @param a
     * @param b
     * @param c
     * @return max
     */

    public static int max3(int a ,int b ,int c){
        int max = a;
        if(max < b){
            max = b;
        }
        if(max < c){
            max = c;
        }
        return max;
    }
}
