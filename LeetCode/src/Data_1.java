import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Project Name: LeetCode
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/02.
 * Copyright © 2020 KawYang. All rights reserved.
 */
public class Data_1 {
    public static void main(String[] args) {

        DateTest();
        CalendarTest();
        WeekTest();


    }

    /**
     * 测试星期 与存入数据的关系
     */
    public static void WeekTest(){
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH)+"今天星期一："+calendar.get(Calendar.DAY_OF_WEEK));
        for (int i = 1; i < 10; i++) {
            calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)+1);
            System.out.println(calendar.get(Calendar.DAY_OF_MONTH)+"今天星期"+(i+1)%7 + ":" + calendar.get(Calendar.DAY_OF_WEEK));
        }
    }
    public static void DateTest(){

        Date date = new Date();
        System.out.println(date);
        String patten = "yy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        String timePattern = sdf.format(date);
        System.out.println(timePattern);
        patten = "yyyy年MM月dd日,E HH时mm分ss秒";
        sdf = new SimpleDateFormat(patten);
        timePattern = sdf.format(date);
        System.out.println(timePattern);
    }
    public static void CalendarTest(){

        Calendar calendar = Calendar.getInstance();
        //或者calender.get(1);
        int year = calendar.get(Calendar.YEAR);
        //从0开始
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DATE);
        //Calendar.HOUR 是12 进制
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.println(year+"年"+month+"月"+day+"日");
        System.out.println(hour+":"+minute+":"+second);
//        calendar.set(2007,11,21);

        System.out.println(calendar.get(Calendar.MONTH));


        System.out.println((calendar.get(Calendar.DAY_OF_WEEK)+6)%7);
    }
}
