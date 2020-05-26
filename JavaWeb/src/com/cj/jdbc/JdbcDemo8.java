package com.cj.jdbc;

import com.cj.domain.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个方法，查询 account 表中的数据将其封装为对象，然后装在集合，返回。
 *
 * @author CJ
 * @version 2020-5-26
 */
public class JdbcDemo8 {
    public static void main(String[] args) {
        List<Account> list = new JdbcDemo8().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }


    /**
     * 查询所有 account 对象
     *
     * @return
     */
    public List<Account> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Account> list = null;
        try {
            // 1. 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "chengjie");
            // 3. 定义sql
            String sql = "select * from account";
            // 4. 获取sql对象
            statement = connection.createStatement();
            // 5. 执行sql
            resultSet = statement.executeQuery(sql);
            // 6. 遍历结果集，封装对象，装载集合
            Account account = null;
            list = new ArrayList<Account>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                account = new Account();
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);

                list.add(account);
            }
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

        return list;
    }
}
