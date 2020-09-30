package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: demo1
 * Created by MacBook Air on 2020/02/24.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class HttpUrlDemo {
    public static void main(String[] args) {
        try{
            //创建URL链接
            URL testUrl = new URL("http://www.baid.com");
            //打开链接
            HttpURLConnection httpURLConnection =(HttpURLConnection) testUrl.openConnection();
            //设置请求方式
            httpURLConnection.setRequestMethod("GET");
            //设置链接超时时间
            httpURLConnection.setConnectTimeout(1000);
            //获取输入流
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            //输出结果
            reader.lines().forEach(System.out::println);
            inputStream.close();
            reader.close();
            httpURLConnection.disconnect();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
