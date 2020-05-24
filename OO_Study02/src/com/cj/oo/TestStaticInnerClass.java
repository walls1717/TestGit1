package com.cj.oo;

/**
 * 测试静态内部类
 * @author CJ
 */

public class TestStaticInnerClass {
    public static void main(String[] args){
        Outer2.Inner2 inner = new Outer2.Inner2();//创建静态内部类
    }
}

class Outer2{

    static class Inner2{

    }
}
