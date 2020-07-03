package cn.walls1717.jedis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool 工具类
 * @version 2020-7-3
 * @author CJ
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {
        // 读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        // 创建
        Properties pro = new Properties();

        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        // 初始化JedisPool
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    /**
     * 获取连接的方法
     * @return
     */
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
