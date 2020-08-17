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

@Component("test")
public class CalImpl2 implements Cal {
    public int add(int num1, int num2) {
        int result = num1 + num2;
        return result;
    }

    public int sub(int num1, int num2) {
        int result = num1 - num2;
        return result;
    }

    public int mul(int num1, int num2) {
        int result = num1 * num2;
        return result;
    }

    public int div(int num1, int num2) {

        int result = num1 / num2;
        return result;
    }
}
