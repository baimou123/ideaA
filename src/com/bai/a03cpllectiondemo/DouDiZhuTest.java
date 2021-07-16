package com.bai.a03cpllectiondemo;

import java.util.*;

/*
* 斗地主 模拟 洗牌
* 牌数：54张，大王，小王，2-10,A,J,Q,K,四个
* ♦，♣，♥，♠
* */
public class DouDiZhuTest {
    public static void main(String[] args) {
        //1.先造出来4个花色
        List<String> colors=new ArrayList<>();
        colors.add("♦");
        colors.add("♥");
        colors.add("♠");
        colors.add("♣");
        //2.造出10 个 2-10
        List<String> numbers=new ArrayList<>();
        for (int i = 2; i <=10 ; i++) {
            numbers.add(i+"");
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");
        //System.out.println("numbers = " + numbers);


        //3.上面的  colors和number进行一个整合。
        //放入到一个新的集合中  如何做到呢？ 嵌套循环
        List<String> pakerBox=new ArrayList<>();
        //Set<String> pakerBox=new HashSet<>();
        for (String color : colors) {
            for (String number : numbers) {
                pakerBox.add(color+number);
            }
        }
        pakerBox.add("Bigking");
        pakerBox.add("littleking");
        System.out.println("pakerBox = " + pakerBox);
        System.out.println("pakerBox = " + pakerBox.size());
        //如果使用set也无法分开排序，改为list，有个方法可以 打乱他，只能打断list
        //因set无序的。

        Collections.shuffle(pakerBox);//打断list的排序  斗地主的学名  洗牌
        System.out.println("pakerBox = " + pakerBox);
        /*Collections.sort(pakerBox);//list的快速排序(不是人工指定的排序，下节课讲 人工指定排序)
        System.out.println("pakerBox = " + pakerBox);*/
        //给player1 player2 player3发牌。
        List<String> player1=new ArrayList<>();//玩家1
        List<String> player2=new ArrayList<>();//玩家2
        List<String> player3=new ArrayList<>();//玩家3
        List<String> dipai=new ArrayList<>();//底牌
        for (int i = 0; i < pakerBox.size(); i++) {
            String pName = pakerBox.get(i);
            /*if (i%3==0) {
                player1.add(pakerBox.get(i));
            }else if(i%3==1){
                player2.add(pakerBox.get(i));
            }else if(i%3==2){
                player3.add(pakerBox.get(i));
            }*/
            if (dipai.contains("♥3") == false) {
            if (i >= 51) {
                dipai.add(pName);
            }else {
                if (i%3 == 0) {
                    player1.add(pName);
                }else if(i%3==1){
                    player2.add(pName);
                }else{
                    player3.add(pName);
                }
            }
            }else{
                System.out.println("底牌不能有♥3，请重新运行");
                break;
            }
        }
        System.out.println("dipai = " + dipai);
        System.out.println("player1 = " + player1);
        System.out.println("player1 = " + player1.size());
        System.out.println("player2 = " + player2);
        System.out.println("player2 = " + player2.size());
        System.out.println("player3 = " + player3);
        System.out.println("player3 = " + player3.size());

        //取最后剩下来的三张作为底牌
        //System.out.println("pakerBox = " + pakerBox.subList(51,54));
        //规定个地主,  规定 谁摸到红桃3 谁是地主,  注意:  底牌里面不能包含红桃3 .

        if(player1.contains("♥3")==true){
            System.out.println("player1是地主");
            player1.addAll(dipai);
            System.out.println("player1 = " + player1);
        }else if(player2.contains("♥3")==true){
            System.out.println("player2是地主");
            player2.addAll(dipai);
            System.out.println("player2 = " + player2);
        }else if(player3.contains("♥3")==true){
            System.out.println("player3是地主");
            player3.addAll(dipai);
            System.out.println("player3 = " + player3);
        }
    }
}
