package com.cj.oo;

/**
 * 测试匿名内部类
 * @auhtor CJ
 */

public class TestAnonymousInnerClass {
    public static void test01(A1 a){
        a.a1();
    }

    public static void main(String[] args){
        TestAnonymousInnerClass.test01(new A1() {
            @Override
            public void a1() {
                System.out.println("AAAAA");
            }
        });//定义类体
    }
}

interface A1{
    void a1();
}


