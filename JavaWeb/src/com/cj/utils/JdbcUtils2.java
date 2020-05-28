package com.cj.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Druid连接池工具类
 * @version 2020-5-28
 * @author CJ
 */
public class JdbcUtils2 {
    private static DataSource dataSource;

    static {
        try {
            // 加载配置文件
            var properties = new Properties();
            properties.load(JdbcUtils2.class.getClassLoader().getResourceAsStream("druid.properties"));

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接
     * @return 返回连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 归还连接
     * @param targets 被归还对象
     */
    public static void close(AutoCloseable... targets) {
        for (AutoCloseable target : targets) {
            try {
                if (target != null) {
                    target.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池对象
     * @return 返回连接池对象
     */
    public static DataSource getDataSource() {
        return dataSource;
    }
}
