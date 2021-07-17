package com.bai.day09;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 通过File输出当前项目目录下的文件"myfile.txt"的名字，大小，最后修改时间。
 * 最后修改时间格式如:2016-03-23 14:22:16
 * @author Xiloer
 *
 */
public class Test1 {
    public static void main(String[] args) {
        File file=new File("C:\\桌面\\myfile.txt");
        //输出文件的名字
        String name = file.getName();
        System.out.println("项目目录下的名字为:"+name);
        //输出文件的大小
        long l = file.length();
        System.out.println("项目目录下文件的大小为:"+l);
        //输出文件最后修改的时间
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat s1=new SimpleDateFormat("2016-03-23 14:22:16");
        //System.out.println("项目目录下的文件最后修改的时间为:"+s1.format(file.lastModified()));
        Calendar cal = Calendar.getInstance();
        long l1 = file.lastModified();
        cal.setTimeInMillis(l1);
        System.out.println(s1.format(cal.getTime()));

    }
}
