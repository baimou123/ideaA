package com.bai.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class test2 {
    public static void main(String[] args) {
        Date date=new Date();
        String partten="yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        String a = sdf.format(date);
        System.out.println("a = " + a);
        
    }

}
