import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LiYang
 * @Project Name: 实验楼
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/15.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class DateDemo {
    public static void main(String[] args) {
        String strDate,strTime;
        Date date = new Date();
        System.out.println("今天的日期是："+date);
        //获取时间戳
        long time = date.getTime();
        System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT）："+time);
        strDate = date.toString();
        //Sat Feb 15 19:11:12 CST 2020
        System.out.println(strDate);
        //截取时间
        strTime = strDate.substring(11,strDate.length()-4);
        System.out.println(strTime);
        //格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        System.out.println(simpleDateFormat.format(date));
    }
}
