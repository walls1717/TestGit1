package com.cj.datasource.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid 演示
 * @version 2020-5-27
 * @author CJ
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        var properties = new Properties();
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(resourceAsStream);
        // 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        // 获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
