package com.cj.jdbc;

import java.sql.*;

/**
 *
 * @version 2020-5-26
 * @author CJ
 */
public class JdbcDemo6 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "chengjie");
            String sql = "select * from account";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            // 6. 处理结果
            // 6.1 让游标向下移动一行
            resultSet.next();
            // 6.2 获取数据
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            double aDouble = resultSet.getDouble(3);

            resultSet.next();
            int id2 = resultSet.getInt(1);
            String name2 = resultSet.getString("name");
            double aDouble2 = resultSet.getDouble(3);

            System.out.println(id + "---" + name + "---" + aDouble);
            System.out.println(id2 + "---" + name2 + "---" + aDouble2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
