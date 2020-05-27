package com.cj.jdbc;

import com.cj.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @version 2020-5-27
 * @author CJ
 */
public class JdbcDemo10 {
    public static void main(String[] args) {
        //键盘录入，接收用户名密码
        var scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = scanner.nextLine();
        System.out.print("请输入密码：");
        String password = scanner.nextLine();
        //调用方法
        boolean flag = new JdbcDemo10().login(userName, password);
        //判断结果，输出不同语句
        if (flag) {
            System.out.println("登录成功");
        } else {
            System.out.println("用户名或密码错误");
        }
    }

    /**
     * 登录方法
     * @param userName 用户名
     * @param password 密码
     * @return 是否登录成功
     */
    public boolean login(String userName, String password) {
        if (userName == null || password == null) {
            return false;
        }
        // 连接数据库判断是否登录成功
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 获取连接
            connection = JdbcUtils.getConnection();
            //定义sql
            String sql = "select * from user where username = '"+userName+"' and password = '"+password+"'";
            //获取执行sql的对象
            statement = connection.createStatement();
            //执行查询
            resultSet = statement.executeQuery(sql);
            //判断
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, connection);
        }

        return false;
    }
}
