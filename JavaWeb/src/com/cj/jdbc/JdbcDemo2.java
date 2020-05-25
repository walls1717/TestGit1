package com.cj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account 表添加一条记录 insert 语句
 *
 * @author CJ
 * @version 2020-5-25
 */
public class JdbcDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 定义 sql
            String sql = "insert into account values (null, '王五', '3000')";
            // 3. 获取 Connection 对象
            connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "chengjie");
            // 4. 获取执行 sql 对象 Statement
            statement = connection.createStatement();
            // 5. 执行 sql 影响的行数
            int count = statement.executeUpdate(sql);
            // 6. 处理结果
            System.out.println(count);
            if (count > 0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
