package com.controller;

import com.alibaba.fastjson.JSON;
import com.bean.Table1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TableServlet",urlPatterns = "/TableServlet")
public class TableServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.service(req, resp);
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //创建一个layui后台的json格式
        ArrayList<Table1> table1s = new ArrayList<>();
        Table1 t1 = new Table1();
        t1.setId(1);
        t1.setBid("[009]");
        t1.setXtname("");
        t1.setNumber(4);
        t1.setLevel("高危");
        t1.setBugurl("www.baidu.com");
        t1.setBugtype("用户遍历漏洞");
        table1s.add(t1);

        Table1 t2 = new Table1();
        t2.setId(2);
        t2.setBid("[008]");
        t2.setXtname("");
        t2.setNumber(4);
        t2.setLevel("高危");
        t2.setBugurl("www.baidu.com");
        t2.setBugtype("用户遍历漏洞");
        table1s.add(t2);

        Table1 t3 = new Table1();
        t3.setId(3);
        t3.setBid("[007]");
        t3.setXtname("");
        t3.setNumber(4);
        t3.setLevel("高危");
        t3.setBugurl("www.baidu.com");
        t3.setBugtype("用户遍历漏洞");
        table1s.add(t3);

        Table1 t4 = new Table1();
        t4.setId(4);
        t4.setBid("[006]");
        t4.setXtname("");
        t4.setNumber(4);
        t4.setLevel("高危");
        t4.setBugurl("www.baidu.com");
        t4.setBugtype("用户遍历漏洞");
        table1s.add(t4);

        Table1 t5 = new Table1();
        t5.setId(5);
        t5.setBid("[005]");
        t5.setXtname("");
        t5.setNumber(4);
        t5.setLevel("高危");
        t5.setBugurl("www.baidu.com");
        t5.setBugtype("用户遍历漏洞");
        table1s.add(t5);

        Table1 t6 = new Table1();
        t6.setId(6);
        t6.setBid("[004]");
        t6.setXtname("");
        t6.setNumber(4);
        t6.setLevel("高危");
        t6.setBugurl("www.baidu.com");
        t6.setBugtype("用户遍历漏洞");
        table1s.add(t6);

        Table1 t7 = new Table1();
        t7.setId(7);
        t7.setBid("[003]");
        t7.setXtname("");
        t7.setNumber(4);
        t7.setLevel("高危");
        t7.setBugurl("www.baidu.com");
        t7.setBugtype("用户遍历漏洞");
        table1s.add(t7);

        Table1 t8 = new Table1();
        t8.setId(8);
        t8.setBid("[002]");
        t8.setXtname("");
        t8.setNumber(4);
        t8.setLevel("高危");
        t8.setBugurl("www.baidu.com");
        t8.setBugtype("用户遍历漏洞");
        table1s.add(t8);

        Table1 t9 = new Table1();
        t9.setId(9);
        t9.setBid("[001]");
        t9.setXtname("");
        t9.setNumber(4);
        t9.setLevel("高危");
        t9.setBugurl("www.baidu.com");
        t9.setBugtype("用户遍历漏洞");
        table1s.add(t9);

        Map map = new HashMap<>();
        map.put("code",0);
        map.put("msg","写啥都行");
        map.put("count",50);
        map.put("data",table1s);
        String s = JSON.toJSONString(map);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
