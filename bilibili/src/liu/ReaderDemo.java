package liu;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class ReaderDemo {
    public static void main(String[] args)throws IOException {
        FileReader fileReader = new FileReader("src/liu/a.txt");

        /**
         *  单个字符读取
         */
        int len;
        while ((len = fileReader.read())!= -1){
            System.out.print((char) len);
        }

        /**
         * 多字符读取
         */
        fileReader = new FileReader("src/liu/a.txt");
        char [] a = new char[1024];

        while ((len = fileReader.read(a)) != -1){
            System.out.println(new String(a,0,len));
        }

        fileReader.close();

    }
}
