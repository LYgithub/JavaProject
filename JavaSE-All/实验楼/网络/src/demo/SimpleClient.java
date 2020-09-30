package demo;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/21.
 * Copyright © 2020 LiYang. All rights reserved.
 * 客户机
 */
public class SimpleClient {
    public static void main(String[] args){
        Socket s1;
        InputStream slIn;
        DataInputStream dis;

        try{

            //IP地址和端口号
            s1 = new Socket("127.0.0.1",5432);
            //获取输入流对象
            slIn = s1.getInputStream();
            dis = new DataInputStream(slIn);

            String st = dis.readUTF();
            System.out.println(st);

            s1.close();
            slIn.close();
            dis.close();

        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
