package com.xiexin.controller;

import com.xiexin.bean.Admin;
import com.xiexin.respcode.Result;
import com.xiexin.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/loginByShiro")
    public Result loginByShiro(@RequestBody  Admin admin){
        System.out.println("admin.getAdminAccount() = " + admin.getAdminAccount());
        // 登录交给 shiro的 securityManager 妈妈桑管理
        Subject subject = SecurityUtils.getSubject(); // subject 是根据  过滤器拿到的
        UsernamePasswordToken  token = new UsernamePasswordToken(admin.getAdminAccount(), admin.getAdminPwd());
        try {
            subject.login(token); // ok
            return new Result();
        } catch (Exception e) {   // 登录不对
            e.printStackTrace();
            return new Result(40001,"账号或者密码不正确");
        }
    }
    //增
// 后端订单增加 -- 针对layui的 针对前端传 json序列化的
    @RequestMapping("/reg")
    public Result reg(@RequestBody Admin admin){ // orders 对象传参, 规则: 前端属性要和后台的属性一致!!!
        String adminPwdMingwen=admin.getAdminPwd();//没加密的明文的
        //随机的几位字母作为salt
        //需要生成几位
        int n = 7;
        //最终生成的字符串
        String str = "";
        for (int i = 0; i < n; i++) {
            str = str + (char)(Math.random()*26+'a');
        }
        System.out.println("str = " + str);
        Md5Hash md5Pwd = new Md5Hash(adminPwdMingwen, str,1024);
        System.out.println("md5Pwd = " + md5Pwd);
        admin.setAdminPwd(md5Pwd.toString());
        admin.setSalt(str);
        int i =  adminService.insertSelective(admin); //传入的是明文的
        if(i==1){
            return new Result();
        }else{
            return new Result(40001,"注册失败，账户名可能存在");
        }

    }


}
