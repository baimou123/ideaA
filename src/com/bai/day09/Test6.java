package com.bai.day09;

import java.io.File;

/**
 * 获取并输出当前目录下所有文件的名字
 * @author Xiloer
 *
 */
public class Test6 {
    public static void main(String[] args) {
        /*File file=new File("./");
        File[] fileName= file.listFiles(pathname -> {
            if (pathname.isFile()) {
                System.out.println("pathname = " + pathname);
                return true;
            }else {
                return false;
            }});*/
        //获取指定目录下的文件名
        /*File dir = new File("../day09/src");
        String[] children = dir.list();
        if (children == null) {
            System.out.println( "目录不存在或它不是一个目录");
        }
        else {
            for (int i=0; i< children.length; i++) {
                String filename = children[i];
                System.out.println(filename);
            }
        }*/
        File dir = new File("./");//获取当前目录下的文件以及文件夹的名称
        printDir(dir);
    }

    public static void printDir(File dir) {
        //获取子文件和目录
        File[] files = dir.listFiles();
        //循环打印
        /**
         * 判断：
         * 当是文件时，打印绝对路径。
         * */
        for (File file : files) {
            //判断
            if (file.isFile()) {
                //是文件，输出文件绝对路径
                System.out.println("文件名：" + file.getAbsolutePath());
            }
        }

    }
}

