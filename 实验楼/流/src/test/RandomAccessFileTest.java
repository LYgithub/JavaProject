package test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/18.
 * Copyright © 2020 LiYang. All rights reserved.
 * Random
 */
public class RandomAccessFileTest {
    public static void main(String[] args) {
        try{
            File file = new File(System.getProperty("user.dir")+"/流/randomAccess.file");
            System.out.println(file);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file,"rw");
            randomAccessFile.seek(10);
            byte [] b = new byte[(int)file.length() - 10];
            randomAccessFile.read(b);
            System.out.println(Arrays.toString(b));
            for (int i = 0; i < b.length; i++) {
                System.out.print((char) b[i]);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
