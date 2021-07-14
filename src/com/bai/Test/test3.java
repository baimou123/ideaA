package com.bai.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出你的生日，输出格式为:yyyy-MM-dd");
        String s = scanner.nextLine();
        if (s.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}")) {//时间格式的意思,\\d:表示匹配0-9的意思,{4}:表示四个数字,-:表示中间连接的字符是-
            Date dirs = sdf.parse(s);
            Date date = new Date();
            long time = date.getTime() - dirs.getTime();
            long day = time / 1000 / 60 / 60 / 24;
            long week = day / 7;
            System.out.println("到今天经历了："+week+"周");
        }else{
            System.out.println("输入格式错误");
        }
    }
}
