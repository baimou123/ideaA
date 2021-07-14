package com.bai.Test;

import java.util.Date;

public class test1 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("date = " + date);
        long time = date.getTime();
        time=time+1000*60*60*24*3L;
        date.setTime(time);
        System.out.println("date = " + date);

    }
}
