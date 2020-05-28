package com.cj.datasource.druid;

import com.cj.utils.JdbcUtils2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使用新的工具类
 * @version 2020-5-28
 * @author CJ
 */
public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 获取连接
            connection = JdbcUtils2.getConnection();
            // 定义 sql
            String sql = " insert into account values(null, ?, ?) ";
            // 获取 pstmt 对象
            preparedStatement = connection.prepareStatement(sql);
            // 给？赋值
            preparedStatement.setString(1, "王五");
            preparedStatement.setDouble(2, 3000);
            // 执行
            int count = preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils2.close(preparedStatement, connection);
        }
    }
}
