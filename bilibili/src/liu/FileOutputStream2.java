package liu;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: liu
 * Created by MacBook Air on 2020/02/25.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileOutputStream2 {
    public static void main(String[] args)  throws IOException {
        FileOutputStream file = new FileOutputStream("src/liu/b.txt");
        file.write('1');
        file.write(48);
        file.write(48);

        byte [] arr = {65,66,67,68};
        //ABCD

        //byte [] arr = {-65,-66,-67,68};
        //???D(中文)
        file.write(arr);

        /**
         * 快速写入字符串
         * 运用String中的getBytes 方法获取字符串
         * UTF-8 3个字节是一个中文
         */
        byte [] b = "\n你好".getBytes();
        System.out.println(Arrays.toString(b));
        file.write(b);

        /**
         * 追加写
         */

        file = new FileOutputStream("src/liu/b.txt",true);
        file.write("\r LiYang".getBytes());


        file.close();


    }
}
