package demo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Date;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        char [] b = {'a','b','c','d','\n'};
        try{
            RandomAccessFile randomAccessFile = new RandomAccessFile(FileInSystemDemo.fPath+"/temp.txt","rw");
            for (int i = 0; i < b.length; i++) {
                randomAccessFile.writeUTF(Arrays.toString(b));
            }
            for (int i = b.length-1;i>=0;i--){
                //移动指针
                randomAccessFile.seek(i*4L);
                System.out.println(randomAccessFile.readInt());
            }
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeInt(10);
            randomAccessFile.writeUTF(new Date().toString());
            randomAccessFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
