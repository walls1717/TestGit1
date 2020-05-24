package com.cj.oo;

/**
 * 测试super
 *
 * super是直接父类对象的引用。
 * 可以通过super来访问父类中被子类覆盖的方法或属性
 *
 * @author CJ
 */

public class TestSuper01 {
    public static void main(String[] args){
        new ChildClass().f();
    }
}

class FatherClass{
    public int value;
    public void f(){
        value = 100;
        System.out.println("FatherClass.value="+value);
    }
}

class ChildClass extends FatherClass{
    public int value;
    //方法重写，重写了父类的方法
    public void f(){
        super.f();//调用父类的普通方法
        value = 200;
        System.out.println("ChildClass.value="+value);
        System.out.println(value);
        System.out.println(super.value);//调用父类对象的成员变量
    }
}
