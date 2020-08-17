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
 */
public class TCPServerSocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket =  serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte [] b = new byte[1024];
        int len;
        len = inputStream.read(b);
        System.out.println(new String(b,0,len));

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好客户端！".getBytes());

        outputStream.close();
        serverSocket.close();
        inputStream.close();

    }
}
