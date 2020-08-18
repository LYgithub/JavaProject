package Net;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: Net
 * Created by MacBook Air on 2020/08/18.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class FileTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("Server.txt");
            fileOutputStream.write("test".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
