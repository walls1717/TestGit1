package com.cj.jdbc;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 *
 * @author CJ
 */

public class Demo05 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");
            conn.setAutoCommit(false); //设为手动提交
            long start = System.currentTimeMillis();
            stmt = conn.createStatement();

            for(int i = 0; i < 20000; i++){
                stmt.addBatch("insert into t_user (username,pwd,regTime) values ('CJ"+i+"',666666,now())");
            }
            stmt.executeBatch();
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("插入两万条数据耗时："+(end - start));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //遵循先使用的后关闭，一定要将三个try catch分开写！
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (stmt != null) {
                    stmt.close();
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