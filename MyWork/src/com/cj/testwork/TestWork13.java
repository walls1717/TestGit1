package com.cj.testwork;

/**
 * 编写 Java 程序用于显示人的姓名和年龄。
 * 定义一个人类Person。
 * 该类中应该有两个私有属性： 姓名 (name) 和年龄 (age) 。
 * 定义构造方法用来初始化数据成员。再定义显示(display()) 方法将姓名和年龄打印出来。
 * 在 main 方法中创建人类的实例然后将信息显示。
 */

public class TestWork13 {
    String name;
    int age;

    //编辑成员信息的方法
    public void person(String name, int age){
        this.name = name;
        this.age = age;
    }
    //输出成员信息的方法
    public void display(){
        System.out.println("姓名："+name);
        System.out.println("年龄："+age);
    }

    public static void main(String[] args){
        TestWork13 u1 = new TestWork13();
        TestWork13 u2 = new TestWork13();//创建了两个新的对象
        u1.person("CJ", 18);
        u2.person("JC", 19);//两个新的对象分别调用person，对其信息进行编辑
        u1.display();
        u2.display();//调用display方法进行打印结果
    }
}
