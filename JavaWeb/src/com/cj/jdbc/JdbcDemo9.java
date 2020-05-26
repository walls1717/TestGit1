package com.cj.jdbc;

import com.cj.domain.Account;
import com.cj.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo9 {
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
            connection = JdbcUtils.getConnection();
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
            JdbcUtils.close(resultSet, statement, connection);
        }
        return list;
    }
}
