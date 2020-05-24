package com.cj.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架测试
 * @version 2020-5-20
 * @author CJ
 */

@Pro(className = "com.cj.annotation.Employee", methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 可以执行创建任意类的对象，可以执行任意方法

        // 1. 解析注解
        // 1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 2. 获取上面的注解对象
        // 其实就是在内存中生成了一个该注解接口的子类实现对象
        Pro annotation = reflectTestClass.getAnnotation(Pro.class);
        // 3. 调用注解对象中定义的抽象方法，获取返回值。
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className);
        System.out.println(methodName);

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
