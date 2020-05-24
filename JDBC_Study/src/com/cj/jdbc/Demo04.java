package com.cj.jdbc;

import java.sql.*;

/**
 * 测试ResultSet结果集的基本用法
 *
 * @author CJ
 */

public class Demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

            String sq1 = "select id,username,pwd from t_user where id>?"; //?占位符
            ps = conn.prepareStatement(sq1);
            ps.setObject(1, 2); //把id大于2的记录读取出来

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1) + "---" + rs.getString(2) + "---" + rs.getString(3));
            }

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