package com.cj.jdbc;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * 测试CLOB 文本大对象的使用
 * 包含：字符串、文件内容插入数据库中的Clob字段，将Clob字段值取出来的操作。
 *
 * @author CJ
 */

public class Demo09 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reader r = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

            ps = conn.prepareStatement("insert into t_user (username,myInfo) values (?,?)");
            ps.setString(1, "CJ");
            //将文本文件内容直接输入到数据库中
//            ps.setClob(2, new FileReader(new File("e:/a.txt")));

            //将程序中的字符串输入到数据库的Clob中
//            ps.setClob(2, new BufferedReader
//                    (new InputStreamReader(new ByteArrayInputStream("asdfasdfasdf".getBytes()))));

            ps = conn.prepareStatement("select * from t_user where id=?");
            ps.setObject(1, 22015);

            rs = ps.executeQuery();
            while (rs.next()) {
                Clob c = rs.getClob("myInfo");
                r = c.getCharacterStream();
                int temp = 0;
                while ((temp = r.read()) != -1) {
                    System.out.print((char)temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (r != null) {
                    r.close();
                }
            } catch (Exception e) {
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