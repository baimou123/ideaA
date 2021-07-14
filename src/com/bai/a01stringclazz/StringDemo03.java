package com.bai.a01stringclazz;
/*
* String类的常用API
* */
public class StringDemo03 {
    public static void main(String[] args) {
                  //0123456789012345
        String str="thinking in java";//java编程思想
        //查询10的字符是什么
        char c=str.charAt(10);
        System.out.println("c = " + c);
        int length=str.length();//注意：length()是个方法，数组的长度是属性
        System.out.println("length = " + length);
        char[] chars=str.toCharArray();//应用点：应用在 对数据的加密
        int x=chars.length;
        System.out.println("x = " + x);
        for (char aChar : chars) {
            System.out.println("aChar = " + aChar);
        }
        //查找给定的字符串的位置
        //如：查找in的位置
        int i=str.indexOf("in");
        System.out.println("i = " + i);
        //从指定位置 进行检索
        int i1=str.indexOf("in",3);
        System.out.println("i1 = " + i1);
        //也可以检索最后一次出现的位置
        int i2 = str.lastIndexOf("in");
        System.out.println("i2 = " + i2);
        String str1="thinking in java";//java编程思想
        //判断 是否 以什么字符开头，以什么字符结尾
        boolean th = str1.startsWith("th");
        System.out.println("th = " + th);
        boolean va = str1.endsWith("va");
        System.out.println("va = " + va);
        //           01234567890123
        String str2="www.oracle.com";
        //String substring(int beginIndex,int endIndex) 截取字符串
        //含头不含尾
        String substring = str2.substring(4, 10);
        System.out.println("substring = " + substring);
        //一下子 截取末尾
        String substring1 = str2.substring(4);
        System.out.println("substring1 = " + substring1);
        String str3="  白 世 纪   ";
        String trim = str3.trim();
        System.out.println("trim = " + trim);//trim只能删除字符串两边的空格，不能删除中间的
        String m="Abc";
        String m1 = m.toLowerCase();
        System.out.println("m1 = " + m1);
        String n="abc";
        String n1 = n.toUpperCase();
        System.out.println("n1 = " + n1);
        System.out.println(m.equals(n));
        System.out.println(m.equalsIgnoreCase(n));
        //把 数字转换成字符串
        int u=110;
        String s = String.valueOf(u);
        System.out.println("s = " + s+1);
        //split() 分割数组
        String nn="zhaoshukun.avi";
        String[] split = nn.split("\\.");
        for (String s1 : split) {
            System.out.println("s1 = " + s1);
        }
        //练习:{"username":"tangseng","age":"500"}  提取json中的  k 和  v ..赋值到一个对象
        //QuJingRen 类------->username,age
        //数据替换
        String mm="t,我爱你"; //甜蜜的
        String mmstr = mm.replaceAll("[a-z]", "甜蜜的");
        System.out.println("mmstr = " + mmstr);
        System.out.println(mm);
        //数据包含
        String mmo="我想静静了";
        boolean jj = mmo.contains("静静");
        System.out.println("jj = " + jj);
        //练习:写一个private方法，需要 传一个string的网址参数，返回 处理后的数据
        //假定 大数据获取了 很多网址，我想要www----com 之间的内容
        //有以下   几类网址
        //www.oracle.com ----> oracle
        //www.oracle.com.cn ----> oracle
        //www.java.oracle.com.cn ----> java.oracle
        //www.lol.game.qq.com.cn ----> lol.game.qq
        //www.game.mycom.com.cn ----> game.mycom
    }
    private static void aa(){
        String s="www.oracle.com";
        String substring=s.substring(4,10);
        System.out.println("substring = " + substring);
    }
}
