package com.cj.singletonpattern;

/**
 * 测试饿汉式单列模式
 *
 * @author CJ
 */

public class SingletonDemo01 {
    //类初始化时，立即加载（没有延时加载的优势）这个对象。加载类时，天然是线程安全的！
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01() {
    }

    //方法没有同步，效用效率高
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}
