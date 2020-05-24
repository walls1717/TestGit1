package com.cj.homework;

public class MembersInternal {
    static int y = 1;
    static class OuterClass {
        int x = 2;
        class InnerClass {
            int i = 5;
        }
    }

    public static void test01(){
        OuterClass o = new OuterClass();
        System.out.println(o.x);
        OuterClass.InnerClass i = new OuterClass().new InnerClass();
        System.out.println(i.i);
    }

    public static void main(String[] args) {
        System.out.println(y);
        test01();
    }
}
