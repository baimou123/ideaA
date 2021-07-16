package com.bai.a02dateandcollect;

import java.util.Calendar;

/*
* 日历类：可以做 日期的计算
* 使用场景，项目中：预约功能，日期计算功能，
* 常用的APP，美柚，疫苗预约，入职日期计算。  旅游模块。
* 创建对象 --->new 出来的
* 对象如果不能被(无参)new: 1)无参构造私有化了，可能是单例模式
*                       2)该类可能是个  接口/抽象类,必须new他实现类(子类)
* */
public class CalendarDemo01 {
    public static void main(String[] args) {
        //创建对象 不仅仅只有new，还有 类的实例方法
        //calendar 比 date 牛x，，，calendar功能是哪个包含了  date的大部分功能，是date的升级版
        Calendar calendar=Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        //日历可以进行计算  不如 增加add
        //增加一个年份  增加10年  场景：买保险 加多少年，纪念日
        /*calendar.add(Calendar.YEAR,10);
        System.out.println("calendar = " + calendar.getTime());*/
        //加月
        /*calendar.add(Calendar.MONTH,1);
        System.out.println("calendar.getTime() = " + calendar.getTime());*/
        //加天
        //calendar.add(Calendar.DAY_OF_YEAR,1);
        //System.out.println("calendar.getTime() = " + calendar.getTime());
        //calendar.add(Calendar.DAY_OF_YEAR,-1);
        //比如  设置当周的周五日期  指定的  日期
        //calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
        System.out.println("calendar.getTime() = " + calendar.getTime());
        //还能计算每个月份的最大值。  5月最大值是31  求月底的时间
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("days = " + days); //31
        // ----日历get方法，  日历的 其他获取方法
        //如：查询今年过了多少天。
        int i = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println("i = " + i);
        //如：查询今天是周几,因为阳历是国外的，从周日开始
        int i1 = calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println("i1 = " + i1);
        //今天是周3
        //今天是周三
        String[] weeks={"周日","周一","周二","周三","周四","周五","周六"};
        int i2 = calendar.get(Calendar.DAY_OF_WEEK)-1;
        System.out.println("今天是:" + weeks[i2]);
        //获取月份  ,注意，月份从0开始
        int i3 = calendar.get(Calendar.MONTH)+1;
        System.out.println("i3 = " + i3);
        //日历set..
        //设置2008年
        calendar.set(Calendar.YEAR,2008);
        System.out.println("calendar = " + calendar);
        //设置月份
        calendar.set(Calendar.MONTH,Calendar.APRIL);//月份从0开始
        System.out.println("calendar = " + calendar.getTime());
        //设置，week...


    }
}
