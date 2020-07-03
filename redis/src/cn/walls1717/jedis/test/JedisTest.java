package cn.walls1717.jedis.test;

import cn.walls1717.jedis.utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis 测试类
 * @version 2020-7-3
 * @author CJ
 */
public class JedisTest {

    /**
     * 快速入门
     */
    @Test
    public void test1() {
        // 获取连接
        Jedis jedis = new Jedis("localhost", 6379);

        // 操作
        jedis.set("username", "zhangsan");


        // 关闭连接
        jedis.close();
    }

    /**
     * string
     */
    @Test
    public void test2() {
        // 获取连接
        // 如果使用空参构造，默认值 “localhost” 6379
        Jedis jedis = new Jedis();

        // 操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        // 可以使用 setex() 方法存储可以指定过期事件的 key value
        jedis.setex("activecode", 20, "hehe");

        // 关闭连接
        jedis.close();
    }

    /**
     * hash
     */
    @Test
    public void test3() {
        // 获取连接
        // 如果使用空参构造，默认值 “localhost” 6379
        Jedis jedis = new Jedis();

        // 操作
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");

        String name = jedis.hget("user", "name");
        System.out.println(name);

        // 获取所有 map 中的数据
        Map<String, String> user = jedis.hgetAll("user");

        // keyset
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }

        // 关闭连接
        jedis.close();
    }

    /**
     * list
     */
    @Test
    public void test4() {
        // 获取连接
        // 如果使用空参构造，默认值 “localhost” 6379
        Jedis jedis = new Jedis();

        // 操作
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "a", "b", "c");

        // 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // 弹出
        String element1 = jedis.lpop("mylist");
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);

        // 关闭连接
        jedis.close();
    }

    /**
     * set
     */
    @Test
    public void test5() {
        // 获取连接
        // 如果使用空参构造，默认值 “localhost” 6379
        Jedis jedis = new Jedis();

        jedis.sadd("myset", "java", "php", "c++");

        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);

        jedis.close();
    }

    /**
     * sortedset
     */
    @Test
    public void test6() {
        // 获取连接
        // 如果使用空参构造，默认值 “localhost” 6379
        Jedis jedis = new Jedis();

        jedis.zadd("mysortedset", 3, "a");
        jedis.zadd("mysortedset", 30, "b");
        jedis.zadd("mysortedset", 300, "c");

        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);
        System.out.println(mysortedset);

        jedis.close();
    }

    /**
     * Jedis 连接池
     */
    @Test
    public void test7() {
        // 创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        // 获取连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("hehe", "haha");

        // 归还到连接池
        jedis.close();
    }

    /**
     * Jedis 连接池工具类使用
     */
    @Test
    public void test8() {
        // 通过连接池工具类获取
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello", "world");
        jedis.close();
    }
}
