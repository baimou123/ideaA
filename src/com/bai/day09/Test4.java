package com.bai.day09;

import java.io.File;

/**
 * 获取并输出当前目录下的所有文件和目录的名字
 * @author Xiloer
 *
 */
public class Test4 {
    public static void main(String[] args) {
        File file=new File("/");
        File[] files = file.listFiles();
        for (File f:files) {
            System.out.println("所有文件:"+f.getName());
        }
        System.out.println("目录名字："+file.getName());
    }
}
