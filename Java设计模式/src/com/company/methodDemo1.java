package com.company;

public class methodDemo1 {
    public static void main(String[] args) {

        //第一种基本数据类型
        int a= 1;
        int b= 2;
        System.out.println("a:"+a+"---"+"b:"+b);
        change(a,b);
        System.out.println("a:"+a+"---"+"b:"+b);
        
        System.out.println("===============================");
        
        //第二中引用类型中的字符串
        String s = "java";
        System.out.println(s);
        change2(s);
        System.out.println(s);
        
        System.out.println("===============================");
        
        //第三中基本类型被包装后的的包装类（Integer,Character,其余都是首字母大写）
        // Integer i = new Integer(10);
        // Integer j = new Integer(20);
        // System.out.println(i+"-----"+j);
        // change3(i,j);
        // System.out.println(i+"-----"+j);
        
    }
        
    public static void change(int a,int b){
        int temp = a;
        a=b;
        b=temp;
        }
        
    public static void change2(String s1){
        s1="helloworld";
    }
        
    public static void change3(Integer i,Integer j){
        int temp = i;
        i=j;
        j=temp;
    }
        
}