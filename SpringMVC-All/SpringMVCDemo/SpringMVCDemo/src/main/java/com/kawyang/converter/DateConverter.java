package com.kawyang.converter;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author LiYang
 * @Project Name: SpringMVCDemo
 * @Package Name: com.kawyang.convertor
 * Created by MacBook Air on 2020/06/26.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class DateConverter implements Converter<String,Date> {

    private String pattern;

    public DateConverter(String Pattern ){
        this.pattern = Pattern;
    }


    @Override
    public Date convert(String s) {
        Date date = null;
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            date = format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
