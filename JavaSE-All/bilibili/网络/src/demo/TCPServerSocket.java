package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/28.
 * Copyright © 2020 LiYang. All rights reserved.
 * 
 * 
 * 
 * 服务器端  ServerSocket 
 */
public class TCPServerSocket {
    public static void main(String[] args) throws IOException {
        // ServerSocket 会等待 客户端发送请求，，一旦接收到请求会创建一个 Socket 与 客户端进行通讯
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("======   ServerStart    =====");
        // 等待客户端发送请求
        Socket socket =  serverSocket.accept();

        // 客户端发送请求后，返回 socket 进行通讯
        InputStream inputStream = socket.getInputStream();

        byte [] b = new byte[1024];
        int len;
        len = inputStream.read(b);
        System.out.println(new String(b,0,len));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好客户端！".getBytes());

        outputStream.close();
        inputStream.close();
        serverSocket.close();

    }
}
