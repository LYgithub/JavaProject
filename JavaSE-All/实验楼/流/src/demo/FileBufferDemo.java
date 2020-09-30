package demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: test
 * Created by MacBook Air on 2020/02/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileBufferDemo {
    public static void main(String[] args) throws IOException {
        int readNumber;
        byte[] readThing = new byte[100];
        BufferedInputStream bIn = new BufferedInputStream(System.in,1);
        BufferedOutputStream bOut = new BufferedOutputStream(System.out);
        for (int i = 0; i < 3; i++) {
            readNumber = bIn.read(readThing);
            bOut.write(readThing,0,readNumber);
            //强制将缓冲区内容输出，如果删除：将所有信息输入完成后，一起进行打印。
            //bOut.flush();
        }

        bIn.close();
        bOut.close();

    }
}
