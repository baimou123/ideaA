package com.bai.a04myio;

import java.io.File;

/*
* io能创建文件，也能创建文件夹
* 海能查看文件
* */
public class IOselectFileDemo01 {
    private static long size=0;
    public static void main(String[] args) {
        //查询当前目录的所有文件
        File file = new File(".");
        File[] files = file.listFiles();
        /*for (File file1 : files) {
            System.out.println("file1 = " + file1);
            if (file1.isDirectory()){
                File[] files1 = file.listFiles();
            }
        }*/
        //有什么样的方法可以  全部查看所有的文件呢？6分
        long size =findAll(file);
        System.out.println("size = " + size+"字节");

        //作业1：遍历你D盘的所有文件，并查找出文件中带有java的文件
        //作业2：遍历你D盘的所有文件，并查找出文件后缀名带有。class的文件
    }
    public static long findAll(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.isDirectory()){
            findAll(file1); //递归
        }else{
                System.out.println("file1 = " + file1.length());
                size+=file1.length();
            }
        }
        return size;
    }
}
