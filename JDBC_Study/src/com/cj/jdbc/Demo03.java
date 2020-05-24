package com.cj.jdbc;

import java.sql.*;

/**
 * 测试PreparedStatement的基本用法
 *
 * @author CJ
 */

public class Demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

            String sq1 = "insert into t_user (username,pwd,regTime) values (?,?,?)"; //?占位符
            ps = conn.prepareStatement(sq1);

//            ps.setString(1,"CJ3"); //参数索引是从1开始计算，而不是0
//            ps.setString(2,"12323456");
//            ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));

            //可以使用setObject方法处理参数
            ps.setObject(1, "CJ4");
            ps.setObject(2, "234sf234");
            ps.setObject(3, new java.sql.Date(System.currentTimeMillis()));

            System.out.println("插入一行记录");
            int count = ps.getUpdateCount();
            System.out.println(count);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}