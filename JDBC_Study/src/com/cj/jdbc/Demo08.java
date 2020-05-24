package com.cj.jdbc;

import lombok.SneakyThrows;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 测试时间处理（java.sql.Date,Time,Timestamp）,取出指定时间段的东西
 *
 * @author CJ
 */

public class Demo08 {
    /**
     * 将字符串代表的日期转为long数字（格式：yyyy-MM-dd hh：mm：ss）
     * @param dateStr
     * @return
     */

    @SneakyThrows
    public static long str2Date(String dateStr) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return format.parse(dateStr).getTime();
    }

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

//            ps = conn.prepareStatement("select * from t_user where regTime>? and regTime<?");
//            java.sql.Date start = new java.sql.Date(str2Date("2020-2-15 10:23:34"));
//            java.sql.Date end = new java.sql.Date(str2Date("2020-4-15 10:23:34"));
//            ps.setObject(1, start);
//            ps.setObject(2, end);

            ps = conn.prepareStatement("select * from t_user where lastLoginTime>? and lastLoginTime<? order by lastLoginTime");
            Timestamp start = new Timestamp(str2Date("2020-3-15 10:20:23"));
            Timestamp end = new Timestamp(str2Date("2020-3-15 13:20:23"));

            ps.setObject(1, start);
            ps.setObject(2, end);
            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id")
                        +"---"+rs.getString("username")
                        +"---"+rs.getTimestamp("lastLoginTime"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

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