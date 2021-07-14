package com.bai.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test4 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入生产日期");
        String s = scanner.nextLine();
        System.out.println("请输入保质期天数");
        int a=scanner.nextInt();
        long times=24*60*60*1000;//一天的毫秒值
        if(s.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}")){//matches:整个字符串完全匹配,find:查找符合的部分
            Date s1 = sdf.parse(s);//把输入的日期字符串转换为日
            Date date = new Date();
            System.out.println("当前日期："+sdf.format(date));
            long time = date.getTime();
            long days = time / (1000 * 60 * 60 * 24);//获取天数
            //算出过期日期的毫秒值
            long time1 = s1.getTime()+times*a;
            //把过期日期的毫秒值转化为日期格式
            Date date1 = new Date(time1);
            System.out.println("你所购买的商品过期日期为："+sdf.format(date1));
            if(days==a){//看过去的天数是否等于保质期天数
                System.out.println("你所购买的商品已过期！");
            }else{//计算输出促销日期，促销日期为：该商品过期日前两周的周三
                //计算促销日期的毫秒值
                long p1 = time1 - (times * 11);
                Date p2 = new Date(p1);
                System.out.println("该产品促销日期为："+sdf.format(p2));
            }
        }else{
            System.out.println("格式不正确！");
        }
    }
}
