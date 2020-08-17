package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            //使用Socket 的字节输出流
            OutputStream outputStream = socket.getOutputStream();
            //使用字节输出流 向服务器发送数据
            outputStream.write("你好服务器!".getBytes());


            InputStream inputStream = socket.getInputStream();
            byte[] b = new byte[1024];
            int len = inputStream.read(b);

            System.out.println(new String(b,0,len));
            outputStream.close();

        }catch (IOException e){
            System.out.println("Error:"+e.toString());
        }
    }
}
