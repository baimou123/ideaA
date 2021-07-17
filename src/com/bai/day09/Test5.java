package com.bai.day09;

import java.io.File;
import java.util.Scanner;

/**
 * 要求用户输入一个文件或目录名，并删除当前目录下的该文件或目录。
 * 可自行手动先在当前项目目录中创建一个要删除的文件或目录，若是目录，还可以
 * 在该目录中继续创建若干级目录和文件。
 * @author Xiloer
 *
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println("请您输入一个你想删除的文件或目录:");
        String s1=new Scanner(System.in).nextLine();
        File file=new File(s1);
        boolean flag=file.delete();
        if (flag){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }
}
