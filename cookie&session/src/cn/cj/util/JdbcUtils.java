package cn.cj.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Jdbc 工具类，使用 druid 连接池
 * @version 2020-6-21
 * @author CJ
 */
public class JdbcUtils {

    private static DataSource ds;

    static {
        try {
            // 创建配置文件对象
            Properties pro = new Properties();
            // 使用类加载器，加载配置文件，获得字节输入流
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            // 初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     * @return 连接池对象
     */
    public static DataSource getDataSource() {
        return ds;
    }

    /**
     * 获取连接对象
     * @return 连接对象
     * @throws SQLException sql异常
     */
    public static Connection connection() throws SQLException {
        return ds.getConnection();
    }
}
