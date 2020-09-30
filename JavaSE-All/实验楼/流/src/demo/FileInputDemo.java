package demo;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileInputDemo {
    public static void main(String[] args) throws IOException {
        try{
            File pPath = new File(System.getProperty("user.dir")+"/流/src/");
            File in = new File(pPath ,"FileInput.txt");
            File out = new File(pPath,"FileOut.txt");
            System.out.println(in);

            FileInputStream fin = new FileInputStream(in);
            FileOutputStream fout = new FileOutputStream(out);
            int textNu;
            while ((textNu = fin.read())!= -1) {
                fout.write(textNu);
                System.out.println(textNu);
            }
            fin.close();
            fout.close();
        } catch (FileNotFoundException e){
            System.out.println("Error:"+e.getMessage());
        }
    }
}
