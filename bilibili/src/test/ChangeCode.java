package test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: test
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ChangeCode {
    public static void main(String[] args) {
        try{
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/test/utf-8.txt"), StandardCharsets.UTF_8);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("src/test/jbk.txt"),"gbk");
            int len;
            while ((len = inputStreamReader.read())!= -1){
                System.out.print((char) len);
                outputStreamWriter.write(len);
            }
            //刷新进文文件
            outputStreamWriter.flush();
            inputStreamReader.close();
            outputStreamWriter.close();
        }catch (IOException e){
            System.out.println("Error:" + e.getMessage());
        }
    }
}
