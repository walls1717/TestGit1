package com.cj.jvm;

/**
 * 测试类加载()
 *
 * @author CJ
 */

public class Demo01 {
    //1.静态初始化块 此处先进行初始化
    static {
        System.out.println("静态初始化Demo01");
    }

    public static void main(String[] args) {
        //2.执行main方法 打印下面这一句话
        System.out.println("Demo01的main方法");
        //创建新的class A 的对象，加载A类
        A a = new A();
        //6.打印width数值
        System.out.println(A.width);
        //类只加载一次
        A a2 = new A();
    }
}

//在加载A类时发现A类继承了A_Father 则先加载父类，于是程序进入到A_Father
class A extends A_Farther {
    public static int width = 100; //静态变量，静态域 field

    //4.静态初始化块
    static {
        System.out.println("静态初始化类A");
        width = 300;
    }

    //5.等待父类的静态初始化块与此类中的静态初始化块全部初始化完毕，创建A对象
    public A() {
        System.out.println("创建A类对象");
    }
}

class A_Farther {
    //3.静态初始化块，程序初始化下面的语句
    static {
        System.out.println("静态初始化A_Father");
    }
}
