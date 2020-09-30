package com.yang.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author LiYang
 * @Project Name: JavaScript
 * @Package Name: com.yang.controller
 * Created by MacBook Air on 2020/09/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class test {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("src/com/yang/x.txt");
        outputStream.write("你好".getBytes());
        outputStream.close();
        System.lineSeparator();
    }
}
