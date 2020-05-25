package com.cj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * account 表 修改记录
 *
 * @author CJ
 * @version 2020-5-25
 */
public class JdbcDemo3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接对象
            connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "chengjie");
            // 3. 定义 sql
            String sql = "update account set balance = 1500 where id = 3";
            // 4. 获取执行 sql 对象
            statement = connection.createStatement();
            // 5. 执行 sql
            int i = statement.executeUpdate(sql);
            // 6. 执行操作
            System.out.println(i);

            if (i > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
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
