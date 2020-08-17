package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: test
 * Created by MacBook Air on 2020/02/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileTest {
    public static void main(String[] args){
        File file1 = new File("/Users/mac/MyCodes/IDEAProjects/实验楼/流/1.txt");
        System.out.println("是否含有文件："+file1.exists());
        //没有文件创建文件 返回true 含有文件 返回false
        File file2 = new File("/Users/mac/MyCodes/IDEAProjects/实验楼/流/2.txt");
        System.out.println(""+file2.delete());
        //没有文件 返回 false 含有文件，删除文件 返回true
        System.out.println("file2是否是目录路径："+file2.isDirectory());
        System.out.println("2.txt是否存在："+ file2.exists());
        fileCopy(file1,file2);

    }
    public static void fileCopy(File file1,File file2){

        int nr_read;
        byte [] read = new byte[10];
        FileInputStream fin;
        FileOutputStream flout;
        try{
            fin = new FileInputStream(file1);
            flout = new FileOutputStream(file2);
            while (true){
                nr_read = fin.read(read);
                //返回读取了多少个byte
                if(nr_read == -1){
                    break;
                }
                flout.write(read,0,nr_read);
                //从read 的 第一个byte 开始，长度为读取的长度
            }
            fin.close();
            flout.close();
            System.out.println("复制完成！");
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}

