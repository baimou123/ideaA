package com.bai.a04myio;

import java.io.RandomAccessFile;

/*
* 文件的拷贝(了解...)
* */
public class IODemoCopy01 {
    public static void main(String[] args) throws Exception {
        RandomAccessFile copyTarget = new RandomAccessFile("javaapi.zip", "r");
        RandomAccessFile secondName = new RandomAccessFile("javaapi副本.zip", "rw");
        int d = -1; //io里面-1就代表着 读取完毕。
        while (true) {
            if ((d = copyTarget.read()) != -1) {
                secondName.write(d);
                System.out.println("文件没有读取到");
            }
            System.out.println("找不到文件，或者不可读");
        }
    }
}
