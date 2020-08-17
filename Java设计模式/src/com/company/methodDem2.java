package com.company;

public class methodDem2 {
    public static void main(String [] args){
        test a = new test();
        System.out.println(a.a);
        change(a);
        System.out.println(a.a);


        String s = "hello ";
        change1(s);
        System.out.println(s);

        String s1 = new String( "hello");
        change1(s1);
        System.out.println(s1);
    }
    
    public static void change(test a){
        a.a = 10;
    }

    public static void change1(String s){
        s = "word!";
    }
}

class test{
    int a ;
}