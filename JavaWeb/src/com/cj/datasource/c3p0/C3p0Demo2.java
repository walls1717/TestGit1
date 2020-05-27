package com.cj.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3p0演示
 * @version 2020-5-27
 * @author CJ
 */
public class C3p0Demo2 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new ComboPooledDataSource();

        for (int i = 1; i <= 11; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":" + connection);

            if (i == 5) {
                connection.close();
            }
        }
//        testNamedConfig();
    }

    public static void testNamedConfig() throws SQLException {
        // 获取 DataSource，使用默认配置
        DataSource dataSource = new ComboPooledDataSource("otherc3p0");
        // 获取连接
        for (int i = 1; i <= 10; i++) {
            Connection connection = dataSource.getConnection();
            System.out.println(i + ":"+ connection);
        }
    }
}
