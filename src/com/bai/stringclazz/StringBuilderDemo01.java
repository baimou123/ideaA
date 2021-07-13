package com.bai.stringclazz;
/*
* StringBuilder(线程不安全，速度快)/Buffer(线程安全的，速度稍微慢)解决  字符串频繁修改的问题
* 意思是String升级了
* String类 重点重用性
* StringBuiler/Buffer倾向于对字符串的修改
* 当用到字符大量的 追加/修改/删除的时候，就使用StringBuilder/Buffer
* StringBuiler的优点：内部有个 可变的字符数组，速度快，内存消耗小。
* 在公司实际开发中，字符串的增删改，要用StringBuilder,StringBuffer
* */
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        String str="好好的学习java";
        StringBuilder sb=new StringBuilder(str);
        //1.追加
        sb.append(",为了找一份优质的工作");
        System.out.println("sb = " + sb);
        //2.修改  为了找一份优质的工作 改为  为了改变世界
        sb.replace(10,19,"为了改变世界");
        System.out.println("sb = " + sb);
        //3.删除
        sb.deleteCharAt(1);//删除指定的字符
        System.out.println("sb = " + sb);
        //3.1删除字符区间   很常用，比如说www.goods.baidu.com
        sb.delete(2,5);
        System.out.println("sb = " + sb);
        //3.2删除全部
        sb.delete( 0, sb.length() );
        //4.插入  增加
        sb.insert(0,"努力活着");
        System.out.println("sb = " + sb);
        //5.对字符串  反转
        sb.reverse();
        System.out.println("sb = " + sb);

    }
}
