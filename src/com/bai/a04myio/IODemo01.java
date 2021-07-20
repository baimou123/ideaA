package com.bai.a04myio;

import java.io.File;
import java.io.IOException;

/*
* File文件
* */
public class IODemo01 {
    public static void main(String[] args) throws IOException {
        File file = new File("io02.text");//配置路径

        /*try {
            boolean newFile = file.createNewFile();//创建新文件
            System.out.println("newFile = " + newFile);
        } catch (IOException e) {
            System.out.println("不能创建新文件");
            e.printStackTrace();
        }*/
        //查看文件是否存在，一定更要有个这个代码，不然文件会被覆盖
        boolean exists = file.exists();
        if (exists ) {
            System.out.println("文件已经存在，boolean值=" + exists);
        }else{
            System.out.println("文件不存在，boolean值=" + exists);
            boolean create = file.createNewFile();
            System.out.println("文件创建成功"+create);
        }
        boolean isFile = file.isFile();
        System.out.println("是否是文件" + isFile);
        boolean isdirectory = file.isDirectory();
        System.out.println("是否是目录" + isdirectory);
        boolean ishidden = file.isHidden();
        System.out.println("是否是隐藏文件" + ishidden);
        System.out.println("file = " + file);
        String name=file.getName();
        System.out.println("name = " + name);
        long length = file.length();
        System.out.println("length = " + length);
        //文件的删除
        if (exists) {
            System.out.println("文件存在了，删除他");
            file.delete();
        }
    }
}
