package com.cj.homework;

public class Count {
    private String name;
    private static int number = 0;  //计数Count对象生成的个数

    Count() {
        name = null;
        number++;
    }

    Count(String n) {
        name = n;
        number++;
    }

    protected void finalize() {
//当有一个Count对象释放时会执行该方法，此时对number减1
        System.out.println("有一个Item对象释放了");
        number--;
    }

    public static void main(String args[]) {
        Count c1 = new Count();
        Count c2 = new Count();
        c1 = null;
        System.out.println("执行垃圾收集前Item对象的个数："
                + number);
//强制执行垃圾收集，观察Count类中number值的变化
        java.lang.System.gc();
        System.out.println("执行垃圾收集后Item对象的个数："
                + number);
        c1 = new Count();
        java.lang.System.gc();
        System.out.println("执行垃圾收集后Item对象的个数："
                + number);
    }
}


