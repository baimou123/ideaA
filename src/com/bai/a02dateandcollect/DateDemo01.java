package com.bai.a02dateandcollect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 企业开发中（java，bigData）日期
* 日期类的层是有一个long值 学名UTC时间
* 1970年1月1日00:00:00开始  计算时间元年
* 日期类有两个包，sql/util,我们用util包下日期
*
* 这个日期类 功能有限，如需 日期计算，需要使用 日历类 解决！！
* */
public class DateDemo01 {
    public static void main(String[] args) {
        //定义一个日期
        Date date = new Date();
        System.out.println("date = " + date);//date为什么会输出Wed Jul 14 09:46:28 CST 2021 ？？？
        //toString()被改写了...可以重新  改为我们自己的时间
        long time = date.getTime();//获得  真实的时间，long值.
        System.out.println("time = " + time);//1626227360217(等于2021-07-14) +10
        /*date.setTime(3626227360217L);
        System.out.println("date = " + date);*/
        //练习题：查看10天后是哪一天？
        time=time+1000*60*60*24*10L;
        date.setTime(time);
        System.out.println("date = " + date);
        //修改 日期显示格式
        String pattern="yyyy-MM-dd HH:mm:ss";
        String pattern1="yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern1);
        String chinaDateStr=sdf.format(date);
        System.out.println("chinaDateStr = " + chinaDateStr);
        //字符串 ----->  转日期
        String dateStr="2018/09/02 23:13:45";
        try {
            Date parse = sdf.parse(dateStr);
            System.out.println("parse = " + parse);
        } catch (ParseException e) {
            System.out.println("你的日期字符串可能不是一个日期。你用心填写一下");
            e.printStackTrace();
        }

    }
}
