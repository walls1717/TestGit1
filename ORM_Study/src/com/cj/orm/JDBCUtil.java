package com.cj.orm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@SuppressWarnings("all")
public class JDBCUtil {

    static Properties pros = null; //可以帮助我们读取和处理资源文件的信息

    static { //加载JDBCUtil类的时候调用
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接MySQL
     * @return
     */
    public static Connection getMysqlConn() {
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlURL"), pros.getProperty("mysqlUser"), pros.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放资源
     * @param targets
     */
    public static void close(AutoCloseable... targets) {
        for (AutoCloseable target : targets) {
            try {
                if (null != target) {
                    target.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
