package com.cj.singletonpattern;

import java.awt.datatransfer.StringSelection;

/**
 * 静态内部类实现方式
 *
 * 这种方式：线程安全，使用效率高，并且实现了延时加载！
 *
 * @author CJ
 */

public class SingletonDemo04 {

    private static class SingletonClassInstance {
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    public static SingletonDemo04 getInstance() {
        return SingletonClassInstance.instance;
    }

    private SingletonDemo04() {
    }
}
