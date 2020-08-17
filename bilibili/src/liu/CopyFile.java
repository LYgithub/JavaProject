package liu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/25.
 * Copyright © 2020 LiYang. All rights reserved.
 * 字节流练习
 */
public class CopyFile {
    public static void main(String[] args) {
        try{
            long start = System.currentTimeMillis();

            FileInputStream fin = new FileInputStream("src/liu/2.jpeg");
            FileOutputStream fout = new FileOutputStream("src/1.jpeg",false);
            byte [] b = new byte[1024 * 20 ];
            /**
             *  1KB 31
             *  2KB 32
             *  10KB 6
             *  20 KB 8
             */
            int len;
            while ((len = fin.read(b)) != -1){
                fout.write(b,0,len);
            }
            fout.close();
            fin.close();

            long end = System.currentTimeMillis();
            System.out.println(end - start);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
