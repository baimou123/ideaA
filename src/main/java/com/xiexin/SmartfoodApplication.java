package com.xiexin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//springboot项目是为了简化ssm项目而存在的
//ssm项目配置比较繁琐，比如，需要配置tomcat，需要有很多个xml去配置 第三方依赖
//而springboot简化成，该内置的就内置，多个xml配置改为 一个properties / xml 文件
//说白了 还是ssm框架！！！ 只不过写起来简单了

@SpringBootApplication   //springboot 应用注解，标记 本项目是springboot项目，必须又这个注解！！！
@MapperScan("com.xiexin.dao")  //持久层的dao包扫描
public class SmartfoodApplication {
    //main方法，项目已启动就会执行该方法
    public static void main(String[] args) {
        //静态的调用springApplication应用，参数为，本项目的 启动类。
        System.out.println("SpringBoot启动了");
        SpringApplication.run(SmartfoodApplication.class, args);
    }
}
