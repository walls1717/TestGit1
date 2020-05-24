package com.cj.oo;

/**
 * 测试abstract
 * 意义就在于：为子类提供统一的。规范的模板。子类必须实现相关的抽象方法
 * @author CJ
 */

public class TestAbstract {
    public static void main(String[] args){
        Stu1 stu = new Stu1();
        stu.studyEveryDay();
        stu.play();
    }
}
//创建了一个抽象类
abstract class Student2{
    //创建抽象方法
    abstract public void studyEveryDay();
}

//作为Student2的子类，必须实现Student2所提供的抽象方法
class Stu1 extends Student2{

    @Override
    public void studyEveryDay(){
        System.out.println("写代码");
    }
    public void play(){
        System.out.println("玩LOL");
    }
}
