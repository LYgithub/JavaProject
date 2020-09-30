package testPro;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * @author LiYang
 * @Project Name: bilibili
 * @Package Name: testPro
 * Created by MacBook Air on 2020/02/29.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Pro {
    public static void main(String[] args) {

        while (true){
        /*
            自定义一个文件的命名规则，防止文件被覆盖掉
            规则：域名+毫秒值 + 随机数
        */
        String fileName = "/Server"+System.currentTimeMillis() + new Random().nextInt(9999)+".txt";

        /*
            让服务器一直处于监听状态 （死循环方法）
            上传文件 -> 创建一个线程
         */

            try{
                //请求 客户端Socket对象
                ServerSocket serverSocket =  new ServerSocket(8888);
                //获取Socket对象
                Socket socket = serverSocket.accept();

                new Thread(() -> {
                    try {
                        upLoad(socket,fileName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
                serverSocket.close();
            } catch (
                    IOException e) {
                System.out.println("ServerSocket Error:"+e.toString());
            }
        }
    }

    public static void upLoad(Socket socket,String filename) throws IOException {
        InputStream inputStream = socket.getInputStream();
        File file = new File("网络/src/test/");

        if(!file.exists()){
            file.mkdir();
        }
        //创建本地输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(file + filename);

        byte [] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b)) != -1){
            //保存到服务器的磁盘上
            fileOutputStream.write(b,0,len);
        }

        //获取网络输出流
        OutputStream outputStream = socket.getOutputStream();
        //给客户端回写
        outputStream.write("文件接收成功！".getBytes());

        fileOutputStream.close();
        socket.close();
    }
}
