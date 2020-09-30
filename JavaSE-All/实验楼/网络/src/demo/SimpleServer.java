package demo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo
 * Created by MacBook Air on 2020/02/24.
 * Copyright © 2020 LiYang. All rights reserved.
 * 服务器
 */
public class SimpleServer {
    public static void main(String[] args) {
        ServerSocket s = null;
        Socket s1 ;
        String sendString = "Hello World!";
        OutputStream slot ;
        DataOutputStream dos;

        try{
            //只给端口号（服务器）
            s = new ServerSocket(5432);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        while (true){
            try{
                s1 = s.accept();
                slot = s1.getOutputStream();
                dos = new DataOutputStream(slot);
                dos.writeUTF(sendString);


                dos.close();
                slot.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
