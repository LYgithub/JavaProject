package Test;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: Test
 * Created by MacBook Air on 2020/02/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Client {
    public static ServerSocket serverSocket;

    public static Socket socket;

    public static OutputStream outputStream;

    public static DataOutputStream dataOutputStream;

    public static void main(String[] args) {

        try{
            Server();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void Server() throws IOException {
        try{
            serverSocket = new ServerSocket(5432);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        while (true){
            socket = new Socket();
            outputStream = socket.getOutputStream();
            dataOutputStream = new DataOutputStream(outputStream);

            Scanner read = new Scanner(System.in);
            dataOutputStream.writeUTF(read.nextLine());

            dataOutputStream.close();
            outputStream.close();
        }
    }
}

