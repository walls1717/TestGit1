package com.cj.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC 工具类
 *
 * @author CJ
 * @version 2020-5-26
 */
public class JdbcUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    // 文件的读取，只需要读取一次即可拿到这些值，使用静态代码块。
    // 读取文件，获取值。
    static {
        // 1. 创建 Properties 集合类。
        // 2. 加载文件
        try {
            Properties pro = new Properties();

            // 获取 src 路径下的文件方式
            /*ClassLoader classLoader = JdbcUtils.class.getClassLoader();
            URL resource = classLoader.getResource("jdbc.properties");
            String path = resource.getPath();*/

            pro.load(new FileReader("D:\\IntelliJ IDEA\\Test\\JavaWeb\\src\\jdbc.properties"));

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            // 注册驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     *
     * @param targets 被释放目标
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
}
