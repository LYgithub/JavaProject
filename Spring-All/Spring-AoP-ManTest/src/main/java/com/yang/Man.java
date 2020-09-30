package com.yang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LiYang
 * @Project Name: Spring-Aop-ManTest
 * @Package Name: com.yang
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Man {
    private String name;
    public void qq(){
        System.out.println("聊QQ");
    }

    public void mm(){
        System.out.println("小动作");
    }
}
