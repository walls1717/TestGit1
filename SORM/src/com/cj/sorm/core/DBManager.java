package com.cj.sorm.core;

import com.cj.sorm.bean.Configuration;
import com.cj.sorm.pool.DBConnPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

/**
 * 根据配置信息，维持连接对象的管理（增加连接池功能）
 *
 * @author CJ
 */
@SuppressWarnings("all")
public class DBManager {
    /**
     * 配置信息
     */
    private static Configuration conf;
    /**
     * 连接池对象
     */
    private static DBConnPool pool;

    static { //静态代码块
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        conf = new Configuration();
        conf.setDriver(pros.getProperty("driver"));
        conf.setPoPackage(pros.getProperty("poPackage"));
        conf.setPwd(pros.getProperty("pwd"));
        conf.setSrcPath(pros.getProperty("srcPath"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUser(pros.getProperty("user"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        conf.setQueryClass(pros.getProperty("queryClass"));
        conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
        conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));

    }

    /**
     * 创建新的Connection对象
     *
     * @return
     */
    public static Connection createConn() {
        try {
            Class.forName(conf.getDriver());
            //目前之间建立连接，后期增加连接池处理，提高效率
            return DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd());
        } catch (Exception e) {
            System.out.println("DBManager.getConn");
            return null;
        }
    }


    /**
     * 获得Connection对象
     *
     * @return
     */
    public static Connection getConn() {
        if (pool == null) {
            pool = new DBConnPool();
        }
        return pool.getConnection();
    }

    /**
     * 释放资源
     *
     * @param targets
     */
    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            pool.close(conn);
    }

    public static void close(Statement ps, Connection conn){
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            pool.close(conn);
    }

    public static void close(Connection conn){
            pool.close(conn);
    }

    /**
     * 返回Configuration对象
     *
     * @return
     */
    public static Configuration getConf() {
        return conf;
    }
}
