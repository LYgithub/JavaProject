package com.item.util.impl;

import com.item.util.Cal;
import org.springframework.stereotype.Component;

/**
 * @author LiYang
 * @Project Name: SpringAOP
 * @Package Name: com.item.util.impl
 * Created by MacBook Air on 2020/06/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
@Component
public class CalImpl implements Cal {
    public int add(int num1, int num2) {
//        System.out.print("add方法：["+num1+"，" +num2 +"]:");
        int result = num1 + num2;
//        System.out.println(result);
        return result;
    }

    public int sub(int num1, int num2) {
//        System.out.print("sub方法：["+num1+"，" +num2+"]:");
        int result = num1 - num2;
//        System.out.println();
        return result;
    }

    public int mul(int num1, int num2) {
//        System.out.print("mul方法：["+num1+"，" +num2+"]:");
        int result = num1 * num2;
//        System.out.println();
        return result;
    }

    public int div(int num1, int num2) {
//        System.out.print("div方法：["+num1+"，" +num2+"]:");
        int result = num1 / num2;
//        System.out.println();
        return result;
    }
}
