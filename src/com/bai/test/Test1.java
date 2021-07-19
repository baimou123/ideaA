package com.bai.test;

import java.io.File;

// 作业1:   遍历 你D盘 的 其中一个文件夹 , 并查找出 文件中带有 java 的 文件.

public class Test1 {
    public static void main(String[] args) {
        File file = new File("D:\\实训\\老师代码");
        String[] arr = file.list();
        for (String string : arr) {
            if(string.endsWith(".java")) {   //
                System.out.println(string+"我是Java文件");
            }
        }

           /* long size = 0;
            File file =new File(".");
            File[] files=file.listFiles();

            System.out.println("size = " + size +"字节");*/
        }

    }
}
