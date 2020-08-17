package Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: Net
 * Created by MacBook Air on 2020/02/29.
 * Copyright © 2020 LiYang. All rights reserved.
 * B/S 版本的Server服务器
 */
public class NetTest {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(8080);
            while(true){
                Socket socket = serverSocket.accept();
                InputStream  inputStream = socket.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String url = bufferedReader.readLine();
                System.out.println(url);
                String [] arr = url.split(" ");
                url = arr[1].substring(10);
                System.out.println(url);

                FileInputStream fileInputStream = new FileInputStream(url);

                OutputStream outputStream =  socket.getOutputStream();

                outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                outputStream.write("Content-Type:text/html\r\n".getBytes());
                outputStream.write("\r\n".getBytes());

                int len ;
                byte[] bytes = new byte[1024];
                while ((len = fileInputStream.read(bytes))!= -1){
                    outputStream.write(bytes,0,len);
                }


                socket.close();
            }


        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
