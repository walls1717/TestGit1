package com.cj.oo;

/**
 * 测试非静态内部类
 *
 * 1.非静态内部类可以直接访问外部类成员， 但是外部类不能直接访问非静态内部类成员
 * 2.非静态内部类不能有静态方法，静态属性和静态初始化块
 * 3.外部类的静态方法，静态代码块不能访问非静态内部类，包括不能使用非静态内部类定义变量，创建实例
 * 4.非静态内部类必须寄存在一个外部类对象里。因此，如果有一个非静态内部类对象
 *   那么一定存在对应的外部类对象，非静态内部类对象单独属于外部类的某个对象
 *
 * @author CJ
 */

public class TestInnerClass {
    public static void main(String[] args){
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();//创建内部类对象的时候必须先创建外部类对象
        inner.show();
    }
}

class Outer{
    private int age = 10;

    public void testOuter(){
        System.out.println("Outer.testOuter()");
    }

    //内部类，可以提供一个良好的封装环境
    class Inner{
        int age = 20;
        public void show(){
            int age = 30;
            System.out.println("外部类的成员变量age="+Outer.this.age);//访问外部类成员变量需要加上外部类名.this.变量
            System.out.println("内部类的成员变量age="+this.age);//访问内部类内部变量加一个this即可
            System.out.println("局部变量age="+age);//访问方法内的局部变量什么都不加直接访问
        }
    }
}
