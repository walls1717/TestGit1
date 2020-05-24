package com.cj.reflect;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架测试
 * @version 2020-5-20
 * @author CJ
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 可以执行创建任意类的对象，可以执行任意方法

        // 1. 加载配置文件
        // 1.1 创建 Properties 对象
        var properties = new Properties();
        // 1.2 加载配置文件，转化为一个集合
        // 1.2.1 获取 class 目录下的配置文件
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        // 2. 获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        // 3. 加载该类进内存
        Class<?> cls = Class.forName(className);

        // 4. 创建对象
        Object o = cls.getConstructor().newInstance();

        // 5. 获取方法对象
        Method method = cls.getMethod(methodName);

        // 6. 执行方法
        method.invoke(o);
    }
}
