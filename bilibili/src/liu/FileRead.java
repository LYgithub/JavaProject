package liu;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileRead {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("src/liu/b.txt");
        int x;

        /**
         * 1. fin.read() : 读取一个字符
         * 2. x = fin.read() 赋值
         * 3. 判断 x 是否等于 -1
         */
        while((x = fin.read()) != -1){
            //一次读取一个字节
            System.out.print((char)x);
        }
        System.out.println();
        fin.close();

        /**
         * 多字节读取
         * byte 有时恰好汉字没有乱码
         */
        byte []  b = new byte[4];
        fin = new FileInputStream("src/liu/b.txt");
        while ((x = fin.read(b))!= -1){
            System.out.println(new String(b,0,x));
        }
}
}
