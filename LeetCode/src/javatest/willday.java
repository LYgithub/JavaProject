package javatest;

import java.util.Calendar;
import java.util.Scanner;

/**
 * @Project Name: LeetCode
 * @Package Name: javatest
 * Created by MacBook Air on 2020/02/04.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class willday {
    public static void main(String[] args) {
        int year,month,day;
        long time1,time2,betweenDays;
        Scanner reader = new Scanner(System.in);
        year = reader.nextInt();
        month = reader.nextInt();
        day = reader.nextInt();
        Calendar calendar = Calendar.getInstance();
        time1 = calendar.getTimeInMillis();
        calendar.set(year,month-1,day);
        time2 = calendar.getTimeInMillis();

        betweenDays = (time2-time1)/(1000*24*60*60);
        System.out.println("距离今天还有："+betweenDays+"天");
        System.out.println("星期："+DayWeek((calendar.get(Calendar.DAY_OF_WEEK)+6)%7));

    }
    public static String DayWeek(int n){
        switch (n){
            case 1: return "一";
            case 2:return  "二";
            case 3:return "三";
            case 4: return "四";
            case 5:return  "五";
            case 6:return "六";
            case 0:return "日";
        }
        return null;
    }
}
