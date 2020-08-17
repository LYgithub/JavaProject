package com.company.抽象;

/**
 * @author LiYang
 * @Project Name: Java
 * @Package Name: com.company.抽象
 * Created by MacBook Air on 2020/05/14.
 * Copyright © 2020 LiYang. All rights reserved.
 */
abstract class Template {
    /**
     * 方法执行时间
     */
    abstract void code();

    public long getTime(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return (end - start);
    }
}


