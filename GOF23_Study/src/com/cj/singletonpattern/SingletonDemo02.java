package com.cj.singletonpattern;

/**
 * 测试懒汉式单列模式
 *
 * @author CJ
 */

public class SingletonDemo02 {
    //类初始化时，不初始化这个对象（延时加载，真正使用的时候再创建）
    private static SingletonDemo02 instance;

    private SingletonDemo02() {
    }

    //方法同步，调用效率低！
    public synchronized static SingletonDemo02 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
