package com.bai;

import com.bai.bean.User;
import com.bai.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    //增删改查
    //查询select * from t_user

    public List<User> selectAll(){
        //dao 层 如何和数据库做对接，我们用的知识点叫做jdbc，很基础的一个 必须的技术
        //很多框架都是基于这个jdbc来的，所以必须学习 牛逼。
        //要连接数据库，就需要用到刚刚DBHelper.getConnection()来创建一个和mysql的一个链接的对象
        //这个对象可以负责和mysql链接
        ArrayList<User> users = new ArrayList<>();
        //步骤1：创建出链接对象
        Connection connection = DBHelper.getConnection();
        //步骤2：创建出sql语句
        String sql="select * from t_user";
        //步骤3：使用链接对象 获取 预编译对象
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=connection.prepareStatement(sql);
            //步骤4：执行 预编译对象，得出结果集
            rs = ps.executeQuery();
            //步骤5：遍历结果集，一一的取对象
            while(rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setReal_name(rs.getString("real_name"));
                user.setImg(rs.getString("img"));
                user.setType(rs.getInt("type"));
                user.setIs_del(rs.getInt("is_del"));
                user.setCreate_time(rs.getString("create_time"));
                user.setModify_time(rs.getString("modify_time"));
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

    //新增
    public int addUser(User user){
        //第一：创建链接对象
        Connection connection = DBHelper.getConnection();
        //第二：sql语句
        String sql="insert into t_user values(null,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=null;
        int i=0;
        try {
            //第三部：预编译sql
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getReal_name());
            ps.setString(4,user.getImg());
            ps.setInt(5,user.getType());
            ps.setInt(6,user.getIs_del());
            ps.setString(7,user.getCreate_time());
            ps.setString(8,user.getModify_time());
            //第四部，执行 预编译对象
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
    public static void main(String[] args) {
        UserDao dao = new UserDao();
//        List<User> users = dao.selectAll();
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }
        User user = new User();
        user.setUsername("sunchaoyang");
        user.setType(1);
        user.setReal_name("孙超阳");
        user.setPassword("123");
        user.setModify_time("2013-09-07");
        user.setIs_del(1);
        user.setImg("xxxx");
        user.setCreate_time("2013-09-07");
        int i=dao.addUser(user);
        System.out.println("i = " + i);
    }
}
