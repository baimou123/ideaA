package com.xiexin.shiro;

import com.xiexin.bean.Admin;
import com.xiexin.bean.AdminExample;
import com.xiexin.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/*
* 自定义的和mybatis数据库结合的realm
*
* realm中，包含 认证（登录） 和 授权2个部分
*
*
* */
public class MybatisRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //写授权！！ 查询3表 可得到 角色和权限。。。、
        //第一个：拿到account
        String principal =(String) principalCollection.getPrimaryPrincipal();
        Map map=new HashMap<>();
        map.put("adminAccount",principal);
        List<Map> maps = adminService.selectMore(map);
        //maps包含了 角色名称 ，权限名称
        HashSet<String> roleNames = new HashSet<>();
        List perms=new ArrayList();
        for (Map map1 : maps) {
            String roleName = (String) map1.get("roleName");
            String qxPerms = (String) map1.get("qxName");
            //循环遍历到 roleNames集合中
            roleNames.add(roleName);
            perms.add(qxPerms);
        }
        //把角色和权限给与 登录的账户
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRoles(roleNames);
        info.addStringPermissions(perms);
        return info;  //触发 授权： 1.界面UI触发，适用于单体项目  2.java方法注解触发，适用于 前后端分离 3.不常用的，自己硬编码触发
        //界面触发要用到aop和jar包支持。
    }

    //认证 登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //AuthenticationToken 这个参数是啥》？？？ 其实就是  UsernamePasswordToken("账号","密码")；
        String account = (String) authenticationToken.getPrincipal();//拿到 剩男的账户名
        //拿到账户名后，能否拿到数据库中的密码？？？
        //怎么拿？ 单表的查询
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminAccountEqualTo(account);
        List<Admin> admins = adminService.selectByExample(example);
        Admin dbAdmin=null;
        if(admins!=null&& admins.size()>0){
             dbAdmin = admins.get(0);
             //获取账户名和密码
            String pwd = dbAdmin.getAdminPwd();
            System.out.println("pwd = " + pwd);
            String salt = dbAdmin.getSalt();
            System.out.println("salt = " + salt);
            //进行token的认证
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(account, pwd, ByteSource.Util.bytes(salt), this.getName());
            System.out.println("simpleAuthenticationInfo = " + simpleAuthenticationInfo);
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

