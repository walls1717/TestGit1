package com.cj.oo;

/**
 * 测试继承
 * 1.Java中只有单继承，只有一个直接的父类。写继承只能写一个。
 * 2.Java的接口可以多继承，类只有单继承
 * 3.子类继承父类可以得到父类全部的属性和方法(除了父类的构造方法)
 *   但不见得可以直接访问(比如，父类的私有属性和方法)
 * 4.如果定义一个类时，没有调用extends，则它的父类是：java.lang.Object
 *
 * @author CJ
 */

public class TestExtends {
    public static void main(String[] args){
        Student stu = new Student();
        stu.name = "CJ";
        stu.height = 178;
        stu.rest();

        Student stu2 = new Student("xixi", 6, "Computer");


        /*测试instanceof，instanceof是二元运算符，左边是对象，右边是类
          当对象是右面类或子类所创建对象时，返回true，否则返回false
         */
        System.out.println(stu2 instanceof Student);
        System.out.println(stu2 instanceof Person);
        System.out.println(stu2 instanceof Object);
        System.out.println(new Person() instanceof Student);
    }
}

class Person{//比如这个没有调用extends，则父类为java.lang.Object
    String name;
    int height;

    public void rest(){
        System.out.println("休息一会!");
    }
}

class Student extends Person {
    String major;

    public void study(){
        System.out.println("学习两小时！");
    }

    public Student(String name, int height, String major){
        this.name = name;
        this.height = height;
        this.major = major;
    }

    public Student(){

    }
}
