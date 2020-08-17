import java.util.Scanner;

/**
 * @Project Name: LeetCode
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/03.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class test1_1 {
    public static void main(String[] args) {
        int x ;
        Scanner read = new Scanner(System.in);
        x  = read.nextInt();
        System.out.println(change(x));
    }
    public static String change(int a){
        StringBuffer b = new StringBuffer();
        int n;
        do{
            n = a%16;
            if(n< 10 ){
                b.insert(0,n);
            }
            else {
                b.insert(0,(char)(n-10+'A'));
            }
            a/=16;
        }while (a!=0);
        return b.toString();
    }
}
