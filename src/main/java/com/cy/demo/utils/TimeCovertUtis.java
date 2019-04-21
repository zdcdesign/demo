package com.cy.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式装换工具类
 */
public class TimeCovertUtis {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    /**
     * date转string
     *
     * @return
     */
    public static String date2String(Date date) {
        return sdf.format(date);
    }

    /**
     * string转date
     *
     * @return
     */
    public static Date string2Date(String date) {
        Date time = null;
        try {
            time = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 时间转时间戳
     *
     * @return
     */
    public static long date2Long(Date date) {
        return date.getTime();
    }

}
