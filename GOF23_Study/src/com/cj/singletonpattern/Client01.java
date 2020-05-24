package com.cj.singletonpattern;

/**
 * @author CJ
 */

public class Client01 {
    public static void main(String[] args) {
        SingletonDemo05 s1 = SingletonDemo05.INSTANCE;
        SingletonDemo05 s2 = SingletonDemo05.INSTANCE;
        System.out.println(s1);
        System.out.println(s2);
    }
}
