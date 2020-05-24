package com.cj.jdbc;

import java.io.*;
import java.sql.*;

/**
 * 测试Blob 二进制大对象的使用
 *
 *
 * @author CJ
 */

public class Demo10 {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc"
                    , "root", "chengjie");

//            ps = conn.prepareStatement("insert into t_user (username,headImg) values (?,?)");
//            ps.setString(1, "CJ");
//            ps.setBlob(2, new FileInputStream("e:/e9.gif"));
//            ps.execute();

            ps = conn.prepareStatement("select * from t_user where id=?");
            ps.setObject(1, 22016);

            rs = ps.executeQuery();
            while (rs.next()) {
                Blob b = rs.getBlob("headImg");
                is = b.getBinaryStream();
                os = new FileOutputStream("e:/a.jpg");
                int temp = 0;
                while ((temp = is.read()) != -1) {
                    os.write(temp);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if (os != null) {
                    os.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                if (is != null) {
                    is.close();
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