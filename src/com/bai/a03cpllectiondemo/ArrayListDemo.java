package com.bai.a03cpllectiondemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
* JDK 8 的快速去集合中的属性
* */
public class ArrayListDemo {
    public static void main(String[] args) {
        Person diaoChan=new Person();
        diaoChan.setAge(18);
        diaoChan.setHeight(167);
        diaoChan.setName("貂蝉");
        Person xiaoQiao=new Person();
        xiaoQiao.setAge(19);
        xiaoQiao.setHeight(140);
        xiaoQiao.setName("小乔");
        Person sunShangXxiang=new Person();
        sunShangXxiang.setAge(22);
        sunShangXxiang.setHeight(170);
        sunShangXxiang.setName("孙尚香");
        //需求：有个曹贼，需要一个String集合，该集合中的值是提取与上面3000个list中的值  把美女的名字都存进去。
        List<Person> list=new ArrayList();
        list.add(diaoChan);
        list.add(xiaoQiao);
        list.add(sunShangXxiang);
        System.out.println("list = " + list);
        
        List<String> names=new ArrayList<>();


        /*names.add(diaoChan.getName());
        names.add(xiaoQiao.getName());
        names.add(sunShangXxiang.getName());
        System.out.println("names = " + names);*/
        //1.遍历list集合，拿出对象的names付给新的names集合中
        /*for (Person s : list) {
            String name = s.getName();
            names.add(name);//2.赋值给新的集合
        }
        System.out.println("names = " + names);*/
        //以上是传统的，新的呢？JDK8  Stream() ,作业1：自我学习JDK8的新特性，如何新的遍历  至少2个demo
        List<String> nameLists = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println("nameLists = " + nameLists);
    }
}
