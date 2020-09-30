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
public class ByteTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream("src/liu/a.txt");
        int x;
        while ((x = fin.read())!= -1 ){
            System.out.println((char)x);
        }
        fin.close();
    }
}
