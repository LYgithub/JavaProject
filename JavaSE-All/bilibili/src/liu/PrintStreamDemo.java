package liu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class PrintStreamDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我是控制台输出！");

        PrintStream ps = new PrintStream(new FileOutputStream("src/liu/d.txt"));
        //修改打印的位置
        System.setOut(ps);
        System.out.println("文件打印！");
    }
}
