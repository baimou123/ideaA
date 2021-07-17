package com.bai.day09;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 要求用户输入一个文件名并使用File在当前目录下创建出来。
 * 若该文件已经存在，则提示用户该文件已经存在。并创建该文件副本：
 * 例如:用户输入"test.txt".若该文件已存在，提示用户存在后，创建名为：test_副本1.txt 的文件
 * 若该文件也存在了，则创建名为:test_副本2.txt 的文件，以此类推
 * @author Xiloer
 *
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        //此扫描器执行当前行，并返回跳过的输入信息。nextLine()
        System.out.println("请输入一个文件夹名:");
        String s1=new Scanner(System.in).nextLine();
        File file=new File(s1);
        //System.out.println(file.getName());
        //将此抽象路径名转换为一个路径名字符串。getPath()
        String path = file.getPath();
        if (path.equals("test.txt")) {
            System.out.println("您输入的文件已存在");
            boolean file1 = file.createNewFile();
            while (file1 == true) {
                file.renameTo(new File("test_副本1"));
                System.out.println("创建副本1成功");
                break;
            }
        }else if (path.equals("test_副本1.txt")){
            System.out.println("您输入的文件已存在");
            boolean file2 = file.createNewFile();
            while (file2==true){
                file.renameTo(new File("test_副本2"));
                System.out.println("创建副本2成功");
                break;
            }
        }
    }
}
