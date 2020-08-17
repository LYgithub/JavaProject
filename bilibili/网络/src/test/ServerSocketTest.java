package test;

import testPro.Pro;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: test
 * Created by MacBook Air on 2020/02/29.
 * Copyright © 2020 LiYang. All rights reserved.
 * 服务器
 *
 */
public class ServerSocketTest {
    public static void main(String[] args) {
        try{
            //请求 客户端Socket对象
            ServerSocket serverSocket =  new ServerSocket(8888);
            //获取Socket对象
            Socket socket = serverSocket.accept();
            Pro.upLoad(socket,"/Server.txt");
            serverSocket.close();

        } catch (
                IOException e) {
            System.out.println("ServerSocket Error:"+e.toString());
        }
    }
}
