package EachDemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: EachDemo
 * Created by MacBook Air on 2020/02/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class EchoServer {
    public static void main(String[] args) {
        try {
            //服务端需要使用ServerSocket类
            ServerSocket serverSocket = new ServerSocket(1080);
            //阻塞 等待客户端连接
            Socket client = serverSocket.accept();
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String userIn;
            while ((userIn = in.readLine()) != null) {
                System.out.println("收到客户端消息：" + userIn);
                //发回客户端
                out.println(userIn);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
