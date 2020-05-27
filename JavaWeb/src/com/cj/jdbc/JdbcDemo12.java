package com.cj.jdbc;

import com.cj.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 事务操作
 * @version 2020-5-27
 * @author CJ
 */
public class JdbcDemo12 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            // 获取连接
            connection = JdbcUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);

            // 定义 sql
            // 张三 -500
            // 李四 +500
            String sql1 = " update account set balance = balance - ? where id = ? ";
            String sql2 = " update account set balance = balance + ? where id = ? ";
            // 获取执行 sql 对象
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            // 设置参数
            preparedStatement1.setDouble(1, 500);
            preparedStatement1.setInt(2, 1);

            preparedStatement2.setDouble(1, 500);
            preparedStatement2.setInt(2, 2);

            preparedStatement1.executeUpdate();
            // 手动制造异常
            int i = 3/0;

            preparedStatement2.executeUpdate();

            // 提交事务
            connection.commit();
        } catch (Exception throwables) {
            // 事务回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            throwables.printStackTrace();
        } finally {
            JdbcUtils.close(preparedStatement2, preparedStatement1, connection);
        }
    }
}
