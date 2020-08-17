package test;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: test
 * Created by MacBook Air on 2020/02/27.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TextSort {
    public static void main(String[] args){
        try{

            // 1. 创建一个HashMap 集合对象，可以存储每行的文本序号（1，2，3...);value 存储每行的内容
            HashMap<String,String> hashMap = new HashMap<>(1024);
            //  2. 创建字符缓冲输入流对象，构造方法绑定字符输入流
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test/TextSort.txt"));
            //  3. 创建字符缓冲输出流对象，构造方法绑定字符输出流
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/test/TextSort1.txt"));
            //  4. 使用字符缓冲输入流中的readline()方法，逐行读取文本内容
            String s ;
            String []s1;
            while ((s= bufferedReader.readLine()) != null ){
                //  5. 对读取到的文本进行切割，获取行号和文本内容，并存储到HashMap集合中（kay 自动排序）
                s1 = s.split("\\.");
                hashMap.put(s1[0],s1[1]);
            }
            //  6. 遍历HashMap 获取键值
            Set<String> set = hashMap.keySet();
            //  7. 使用字符缓冲输出流中的writeLine() 方法，写入文本
            for (String key:set){
                bufferedWriter.write(hashMap.get(key));
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            //  8. 释放资源
            bufferedReader.close();
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Error:"+e.getMessage());
        }

    }
}
