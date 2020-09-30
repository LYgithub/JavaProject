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
 * http://localhost:8080/Server.txt
 */
public class NetTest {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8080);){
            // 创建服务器对象，并且设置端口号为 8080
            while(true){

                // 监听客户端发送请求
                Socket socket = serverSocket.accept();
                InputStream  inputStream = socket.getInputStream();
                OutputStream outputStream =  socket.getOutputStream();

                // 设置响应的相关数据
                outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                // 设置编码格式
                outputStream.write("Content-Type:text/html;charset=utf-8\r\n".getBytes());
                outputStream.write("\r\n".getBytes());

                try{
                    // 获取请求的URL
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String url = bufferedReader.readLine();
                    System.out.println(url);
                    String [] arr = url.split(" ");

                    // 裁剪出 需要获取的文件信息
                    String file = arr[1].substring(1);
                    System.out.println(file);

                    FileInputStream fileInputStream = new FileInputStream("src/Net/" + file);

                    int len ;
                    byte[] bytes = new byte[1024];

                    while ((len = fileInputStream.read(bytes))!= -1){
                        outputStream.write(bytes,0,len);
                    }

                    fileInputStream.close();

                }catch (Exception e) {
                    e.printStackTrace();
                    outputStream.write(e.getMessage().getBytes());
                }finally {
                    outputStream.close();
                    socket.close();
                }
            }
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
