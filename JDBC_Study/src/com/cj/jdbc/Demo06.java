package com.cj.jdbc;

import java.sql.*;

/**
 * 测试事务的基本概念用法
 *
 * @author CJ
 */

public class Demo06 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

            conn.setAutoCommit(false); //JDBC中默认是true,自动提交事务

            ps1 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?)");
            ps1.setObject(1, "CJ");
            ps1.setObject(2, "123456");
            ps1.execute();
            System.out.println("插入一个用户,CJ");

            Thread.sleep(6000);

            ps2 = conn.prepareStatement("insert into t_user (username,pwd) values (?,?,?)");
            ps2.setObject(1, "搞起");
            ps2.setObject(2, "1234356");
            ps2.execute();
            System.out.println("插入一个用户,搞起");



            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                conn.rollback(); //回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {

            try {
                if (ps1 != null) {
                    ps1.close();
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