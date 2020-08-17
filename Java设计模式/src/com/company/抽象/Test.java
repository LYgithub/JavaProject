package com.company.抽象;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.抽象
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
class Test {
    public static void main(String[] args) {
        Template template = new Template() {
            @Override
            void code() {
                int n = 150000;
                double a = 1, b = 1, c;
                for (int i = 0; i < n; i++){
                    System.out.println(a);
                    c = a + b;
                    b = a;
                    a = c;
                }
            }
        };
        System.out.println("时间：" + template.getTime());

    }
}
