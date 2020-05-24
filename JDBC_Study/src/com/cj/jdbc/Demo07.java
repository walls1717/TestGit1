package com.cj.jdbc;

import java.sql.*;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）
 *
 * @author CJ
 */

public class Demo07 {
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

            for (int i = 0; i < 1000; i++) {
                ps1 = conn.prepareStatement("insert into t_user (username,pwd,regTime,lastLoginTime) values (?,?,?,?)");
                ps1.setObject(1, "CJ"+i);
                ps1.setObject(2, "123456");

                int rand = 1000000000 + new Random().nextInt(1000000000);

                Date date = new java.sql.Date(System.currentTimeMillis() - rand);
                //如果需要指定日期，可以使用Calendar，DateFormat
                Timestamp stamp = new Timestamp(System.currentTimeMillis()- rand);

                ps1.setDate(3, date);
                ps1.setTimestamp(4, stamp);
                ps1.execute();
            }


            System.out.println("插入一个用户,CJ");

        } catch (Exception e) {
            e.printStackTrace();
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