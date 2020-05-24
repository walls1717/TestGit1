package com.cj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 测试 Statement接口的用法，执行 SQL语句，以及 SQL注入问题
 */

public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接(连接对象内容其实包含了Socket对象，是一个远程连接。比较耗时！这是Connection对象管理的一个要点)
            //真正开发中，为了提高效率，都会使用连接池来管理
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=UTC"
                    , "root", "chengjie");

            stmt = conn.createStatement();
            String name = "赵六";
            String sq1 = "insert into book (图书编号,图书名称,出版社,库存) values (666,'"+name+"','"+name+"', 666)";
            stmt.execute(sq1);

//            //测试SQL注入
//            String id = 5+"";
//            String sq1 = "delete from t_user where id=4";
//            stmt.execute(sq1);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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