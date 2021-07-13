package com.bai.stringclazz;
/*
* sb对性能影响
* */
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        String str="a";
        StringBuilder sb=new StringBuilder(str);
        System.out.println(System.currentTimeMillis());//当前日期的long值
        long l=System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            sb.append(str);
            System.out.println("sb = " + sb);
        }
        System.out.println(System.currentTimeMillis()-l);
    }
}
