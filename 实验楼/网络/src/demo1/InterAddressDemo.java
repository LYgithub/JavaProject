package demo1;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UTFDataFormatException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo1
 * Created by MacBook Air on 2020/02/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class InterAddressDemo {
    public static void main(String[] args) {
        try{
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println("inetAddress = " + inetAddress);

            String ip = inetAddress.toString().split("/")[1];
            System.out.println("ip = " + ip);

            //根据IP获取主机名
            InetAddress inetAddress1 = InetAddress.getByName(ip);
            System.out.println("get hostname by IP address:"+inetAddress1.getHostName());
            System.out.println("localhost:"+ InetAddress.getLocalHost());

        }catch (UnknownHostException e){
            System.out.println("ERROR:" + e.getMessage());
        }
    }
}
