package com.bai.a03cpllectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
* 集合：非常重要!! 有一个接口
* */
public class CollectionDemo {
    public static void main(String[] args) {
        //ArrayList c1=new ArrayList();
        Collection c1=new ArrayList();
        //add 增加
        c1.add("唐僧--执着的目标");
        c1.add("吉吉国王--过硬的技术");
        c1.add("猪八戒--lsp,体贴关怀");
        c1.add("臭咸鱼--稳重的劳动");
        c1.add("白龙马--代表出门宝马，面儿");
        System.out.println("c1 = " + c1);
        //尺寸
        int size = c1.size();
        System.out.println("size = " + size);
        boolean empty = c1.isEmpty();
        System.out.println("empty = " + empty);
        //集合的清空
        //c1.clear();
        System.out.println("c1 = " + c1);
        boolean empty1 = c1.isEmpty();
        System.out.println("empty1 = " + empty1);
        //集合都实现了collection接口
        //集合遍历3种
        //one
        /*for (int i = 0; i <c1.size(); i++) {
            System.out.println("c1 = " + c1.get(i));
        }*/
        //思考题：为什么collection不能使用for循环呢？？？换句话说？为什么不能根据索引来取值呢？
        //因为set集合没有索引下标,所以for循环不能使用到collection中。
        for (Object o : c1) {
            System.out.println("o = " + o);
        }
        //迭代器和for循环的区别
        //迭代器工作:有游标，问下一个，有没有元素，如果有，就拿出，没有就结束
        //for循环的工作:把集合0---N，从0开始取。拿下标。

    }
}
