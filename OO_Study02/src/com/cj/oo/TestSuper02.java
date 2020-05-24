package com.cj.oo;

/**
 * 测试继承树追溯
 * @author CJ
 */

public class TestSuper02 {
    public static void main(String[] args){
        System.out.println("开始创建第一个ChildClass对象.......");
        new ChildClass1();//调用构造方法
    }
}

class FatherClass1{
    public FatherClass1(){
        System.out.println("创建FatherClass1");
    }
}

class ChildClass1 extends FatherClass1{
    public ChildClass1(){
        /*
            构造方法的第一句总是super();
            用来调用父类对应的构造方法。
            所以，流程就是：先向上追溯到Object，然后再依次向下执行类的初始化块和构造方法
            直到子类为止

            Ps.静态初始化块的调用顺序，与构造方法调用顺序一样
         */
        super();
        System.out.println("创建ChildClass1");
    }
}
