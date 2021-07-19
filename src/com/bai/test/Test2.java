package com.bai.test;

import java.io.File;

// 作业2:   遍历 你D盘 的 其中一个文件夹 , 并查找出 文件后缀名带有.class的文件
public class Test2 {
    public static void main(String[] args) {
        File file = new File("D:\\实训\\老师代码");
        String[] arr = file.list();
        for (String string : arr) {
            if(string.endsWith(".class")) {
                System.out.println(string+"我是class文件");
            }
           /* long size = 0;
            File file =new File(".");
            File[] files=file.listFiles();

            System.out.println("size = " + size +"字节");*/
        }

    }
}
