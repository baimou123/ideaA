package com.bai.a04myio;

import java.io.File;

/*
* file的其他。
*
* */
public class IODemo02 {
    public static void main(String[] args) {
        //创建文件夹，所有IO底层都不是java操作的，而是java地调用 所在系统的底层的操作。
        File file=new File("io");
        if (!file.exists()){
            file.mkdir();//不加s只能1层，加s可以多层，一般用s

        }else{
            System.out.println("文件已经存在");
        }
        File file1 = new File("io1/io2/io3/io4/io5");
        if (!file1.exists()){
            file1.mkdirs();
        }else{
            System.out.println("文件已经存在");
        }
    }
}
