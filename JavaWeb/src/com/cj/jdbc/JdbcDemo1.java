package com.cj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * JDBC 快速入门
 * @version 2020-5-25
 * @author CJ
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 1. 导入驱动 Jar 包
        // 2. 注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
        // 3. 获取数据库连接对象
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "chengjie");
        Connection conn = DriverManager.getConnection("jdbc:mysql:///db4", "root", "chengjie");
        // 4. 定义 sql 语句
//        String sql = "update account set balance = 2000 where id = 1";
        String sql = "update user set password = 2000";
        // 5. 获取执行 sql 对象 Statement
        Statement stmt = conn.createStatement();
        // 6. 执行
        int count = stmt.executeUpdate(sql);
        // 7. 处理结果
        System.out.println(count);
        // 8. 释放资源
        stmt.close();
        conn.close();
    }
}
