package com.bai.dao;

import com.bai.bean.User;
import com.bai.util.DBHelper;
import com.bai.util.PageBeanUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//dao层应该是个接口，因为可以使用AOP，目前不用AOP，可以直接写成类
public class UserDAO {
    //增 删 改 查
    //查询 select * from t_user;
    //dao层如何和数据库对接，我们用到的知识点叫做jdbc，很基础的一个必须的技术
    //很多框架都是基于这个jdbc来的
    //要连接数据库，就需要用到刚刚 DBHelper.getConnection() 来创建一个 和mysql连接的对象
    //这个对象可以负责和mysql连接

    //登录select * from t_user where username=? and password=?
    public User login(String username,String password){
        User user =null;
        // 1. 创建链接
        Connection connection = DBHelper.getConnection();
        // 2. 建出 sql 语句
        String sql = " select * from t_user where username = ? and password = ?  ";
        // 3. 使用链接对象 获取 预编译对象
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            // 4. 执行 预编译对象,得出结果集
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setCreate_time(rs.getString("create_time"));
                user.setImg(rs.getString("img"));
                user.setIs_del(rs.getInt("is_del"));
                user.setModify_time(rs.getString("modify_time"));
                user.setPassword(rs.getString("password"));
                user.setReal_name(rs.getString("real_name"));
                user.setType(rs.getInt("type"));
                user.setUsername(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    //查询
    public List<User> selectAll(){
        //1.创建出连接对象
        List<User> users = new ArrayList<>();
        Connection connection = DBHelper.getConnection();
        //2.创建出sql语句
        String sql="select * from t_user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //3.使用连接对象获取预编译对象
             ps = connection.prepareStatement(sql);
            System.out.println("ps = " + ps);
            //4.执行预编译对象 得出结果集
             rs = ps.executeQuery();
            //5.遍历结果集
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setCreate_time(rs.getString("create_time"));
                user.setImg(rs.getString("img"));
                user.setIs_del(rs.getInt("is_del"));
                user.setModify_time(rs.getString("modify_time"));
                user.setPassword(rs.getString("password"));
                user.setReal_name(rs.getString("real_name"));
                user.setType(rs.getInt("type"));
                user.setUsername(rs.getString("username"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    //动态的带参数的分页查询  这个 很吊！以后mybaits会简化
    //m是页数
    //n是条数
    public List<User> selcetAllByParam(int page,int limit){
        List<User> lists=new ArrayList<>();
        //1.开连接
        Connection connection = DBHelper.getConnection();
        //2.写sql
        String sql="select * from t_user limit ? , ?";
        PreparedStatement ps=null;
        ResultSet rs=null;
        PageBeanUtil pageBeanUtil=new PageBeanUtil(page,limit);//因为第一个需要？求出来
        //3.编译sql
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,pageBeanUtil.getstart());//这是索引
            ps.setInt(2,limit);
            //4.执行sql
            rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setCreate_time(rs.getString("create_time"));
                user.setImg(rs.getString("img"));
                user.setIs_del(rs.getInt("is_del"));
                user.setModify_time(rs.getString("modify_time"));
                user.setPassword(rs.getString("password"));
                user.setReal_name(rs.getString("real_name"));
                user.setType(rs.getInt("type"));
                user.setUsername(rs.getString("username"));
                lists.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lists;
    }

    //查询总条数
    public int selectCount(){
        int total=0;
        //1.开连接
        Connection connection = DBHelper.getConnection();
        //2.写sql
        String sql="select count(*) total from t_user";
        PreparedStatement ps=null;
        ResultSet rs=null;
        //3.编译
        try {
            ps = connection.prepareStatement(sql);
            //4.执行
            rs = ps.executeQuery();
            if (rs.next()) {
                total=rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return total;
    }

    //新增
    public int addUser(User user){
        //1.创建连接对象
        Connection connection = DBHelper.getConnection();
        //2.sql语句,因为添加的数据是变量所以用问好代替
        String sql = "insert into t_user values (null,?,?,?,?,?,?,?,? )";

        PreparedStatement ps = null;
        int i = 0;
        try {
            //3.预编译sql
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getReal_name());
            ps.setString(4,user.getImg());
            ps.setInt(5,user.getType());
            ps.setInt(6,user.getIs_del());
            ps.setString(7,user.getCreate_time());
            ps.setString(8,user.getModify_time());
            //4.执行预编译对象
            i = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    //删除
    public int delete(int id){
        //1、步骤1、创建链接对象
        Connection connection = DBHelper.getConnection();
        //2、sql语句因为添加的数据是变量 ，所以要用?代替
        String sql="delete from  t_user where id=?";

        PreparedStatement ps=null;
        int i=0;
        try {
            //3、预编译
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  i;
    }

    //修改
    public int update(User user){
        //1、步骤1、创建链接对象
        Connection connection = DBHelper.getConnection();
        //2、sql语句因为添加的数据是变量 ，所以要用?代替
        String sql="update t_user set username=?,password=?,real_name=?,img=?,type=?,is_del=?,create_time=?,modify_time=? where id=?";
        PreparedStatement ps=null;
        int i=0;
        try {
            //3、预编译
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getReal_name());
            ps.setString(4,user.getImg());
            ps.setInt(5,user.getType());
            ps.setInt(6,user.getIs_del());
            ps.setString(7,user.getCreate_time());
            ps.setString(8,user.getModify_time());
            ps.setInt(9,user.getId());
            i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  i;

    }

    public static void main(String[] args) {
        UserDAO dao = new UserDAO();

        //查询
        /*List<User> users = dao.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }*/

        //新增
        /*User user = new User();
        user.setUsername("xiaohuihui");
        user.setType(1);
        user.setReal_name("小灰灰");
        user.setPassword("123");
        user.setModify_time("2021-08-09");
        user.setIs_del(1);
        user.setImg("xxxx");
        user.setCreate_time("2021-08-09");
        int i = dao.addUser(user);
        System.out.println("i = " + i);*/

         //删除
        /*int i=dao.delete(62);
        System.out.println("i = " + i);*/

        //修改
        /*User user = new User();
        user.setId(12);
        user.setUsername("灰灰");
        user.setType(1);
        user.setReal_name("小灰灰");
        user.setPassword("1234567");
        user.setModify_time("2021-08-09 13:14:20");
        user.setIs_del(1);
        user.setImg("xxxx");
        user.setCreate_time("2020-07-19");
        int i=dao.update(user);
        System.out.println("i = " + i);*/

        //登录
//        User abc = dao.login("test", "123456");
//        System.out.println("abc = " + abc);
        //分页查询的测试
//        List<User> users = dao.selcetAllByParam(1, 5);
//        System.out.println("users = " + users);
//        System.out.println("users = " + users.size());
        //查总条数的测试
        int i=dao.selectCount();
        System.out.println("i = " + i);
    }
}
