package com.kawyang;

/**
 * @author LiYang
 * @Project Name: Spring-Ioc-Printer
 * @Package Name: com.kawyang.impl
 * Created by MacBook Air on 2020/08/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public interface Paper {
    public static final String newLine = "\r\n";

    /**
     * 打印字符
     * @param c
     */
    public void putIntChar(char c);

    /**
     * 获取文本信息
     * @return 文本内容
     */
    public String getContext();
}
