package test;

/**
 * @author LiYang
 * @Project Name: JavaTest
 * @Package Name: test
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class easy {
    public static void main(String[] args) {
        test();
        for(int i = 0;i<100;i++){
            for (int j = 0; j < 100; j++) {
                if(j +j-i == 70 && i-(j-i) == 1){
                    System.out.println(i+" "+ j);
                }
            }
        }
    }
    public static void test(){
        int i,j,k;
        for ( i = 0; i < 45; i++) {
            for ( j = 0; j < 45; j++) {
                for ( k = 0; k < 45; k++) {
                    if(equal(i+2,j-2,2*k,(45-i-j-k)/2.0) ){
                        System.out.println(i+" "+j+" "+k+" "+(45-i-j-k));
                    }
                }
            }
        }
    }
    public static boolean equal(int a,int b,int c,double d){
        if(a == b){
            if(d == c){
                if(b == d){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
