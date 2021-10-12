package com.xiexin.shirotest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

/*
* shiro 的认证
* */
public class ShiroIni {

    //shiro 3大概念 ：subject（用户的请求，主体），security Manager（Shiro的管理员），realms（数据库）
    //realms分为：ini realm，jdbc realm，自定义的realm -- 常用自定义（mybaits，，，）

    @Test
    public void test01(){
        //1.realms
        IniRealm iniRealm = new IniRealm("classpath:shiro.ini");
        //2.security Manager
        DefaultSecurityManager sm = new DefaultSecurityManager();
        sm.setRealm(iniRealm);
        //以上步骤是把realm注入到sm当中，即 他们2个联系在了一起。下面就剩下subject了
        //subject 不是new出来的！！！！ 因为subject 是一个实打实的对象！！！原本就有的！！！
        //只需要用shiro的类做个接待就可以了。
        SecurityUtils.setSecurityManager(sm); // 接管sm
        Subject subject = SecurityUtils.getSubject();
        //就可以使用subject了
        //拟定一个虚拟的账户和密码
        String userName="xiexin";
        String userPwd="123";
        //在这里，利用shiro 把userName 和 userPwd 变为一个token
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName,userPwd);
        System.out.println("顾客登录的时候把账户名和密码 加工后的token = " + usernamePasswordToken);


        UsernamePasswordToken dbToken = new UsernamePasswordToken("xiexin", "123");
        System.out.println("数据库中 把账户名和密码 加工后的token = " + dbToken);
         //注意：这个登录的方法是shiro提供的 以后我们自己不写登录！！！

        try {
            subject.login(usernamePasswordToken);
            System.out.println("登录成功");
        } catch (UnknownAccountException e) {
            System.out.println("账户名不对");
            e.printStackTrace();
        }catch (IncorrectCredentialsException e) {
            System.out.println("密码不对");
            e.printStackTrace();
        }
    }
}
