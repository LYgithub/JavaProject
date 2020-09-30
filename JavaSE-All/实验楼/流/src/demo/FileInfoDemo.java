package demo;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileInfoDemo {
    public static void main(String[] args) {
        File file = new File("/Users/mac/MyCodes/IDEAProjects/实验楼/流/");
        System.out.println("文件是否存在:"+file.exists());
        System.out.println("文件或者目录名：" + file.getName());
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("父目录：" + file.getParent());
        System.out.println("文件路径：" + file.getPath());
        System.out.println("最后修改时间："+new Date(file.lastModified()));
        //判断文件是否是目录
        if (file.isDirectory()) {
            //打印目录中的文件
            Arrays.stream(Objects.requireNonNull(file.list())).forEach(System.out::print);
            System.out.println("==========");
        }
        System.out.println("是否隐藏：" + file.isHidden());
        System.out.println("是否存在：" + file.exists());
    }
}
