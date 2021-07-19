package com.bai.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

// 作业3:  使用线程的sleep方法 做一个控制台显示时间 ,  格式是:  2021-07-17 23:45:动态的秒
//时间是动态的..
public class Test3 {
    public static void main(String[] args) throws ParseException {
        //创建定时器对象
        Timer time = new Timer();
        //指定定时任务：Timer.schedule(定时任务,第一次执行时间,执行时间间隔):
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//获取时间
        //调用格式化方法将字符串转换成日期
        Date firstTime = sdf.parse("2021-07-17 23:45:00");;
        time.schedule(new Task1(),firstTime,1000*1);
    }
}
class Task1 extends TimerTask {
    public void run(){
        //这个代码块里写自己需要执行的任务
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sdf.format(new Date());//格式化返回当前时间
        System.out.println(time);
    }
}
