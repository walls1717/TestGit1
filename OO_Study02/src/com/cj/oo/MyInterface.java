package com.cj.oo;

/**
 * 接口
 * 接口只定义规范，不定义具体的实现
 * 一个接口可以继承多个父接口
 * @author CJ
 */

public interface MyInterface {
    int MAX_AGE = 100;
    void test01();
}

class MyClass implements MyInterface{

    @Override
    public void test01() {
        System.out.println(MAX_AGE);
        System.out.println("MyClass.test01()");
    }
}
