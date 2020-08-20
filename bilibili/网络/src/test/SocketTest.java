package test;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: test
 * Created by MacBook Air on 2020/02/29.
 * Copyright © 2020 LiYang. All rights reserved.
 * 客户端
 * 读取本地文件，上传服务器，读取服务器回写数据
 */
public class SocketTest {
    public static void main(String[] args) {
        try{
            //创建本地输入流
            FileInputStream fileInputStream = new FileInputStream("src/test/Socket.txt");
            //创建客户端对象
            Socket socket = new Socket("127.0.0.1",8888);
            //获取网络字节输出流对象
            OutputStream outputStream = socket.getOutputStream();
            int len;
            byte [] b = new byte[1024];
            //读取本地文件
            while ((len = fileInputStream.read(b))!= -1){
                //上传到服务器
                outputStream.write(b,0,len);
            }

            socket.shutdownOutput();

            //获取网络字节输入流
            InputStream inputStream = socket.getInputStream();
            //读取服务器回写数据
            len = inputStream.read(b);
            System.out.println(new String(b,0,len));

            //释放资源
            fileInputStream.close();
            socket.close();

        }catch (IOException e){
            System.out.println("Socket Error:"+e.toString());
        }

    }
}
