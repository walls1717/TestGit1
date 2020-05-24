/**
 * 测试重写
 * @author CJ
 */

package com.cj.oo;

public class TestToString {
    public static void main(String[] args){
        TestToString to = new TestToString();
        System.out.println(to.toString());//测试toString，功能是返回类名+@+16进制的hashcode

        Person2 p2 = new Person2("CJ", 19);
        System.out.println(p2.toString());
    }

    //此处对toString进行重写
    @Override
    public String toString(){
        return "测试Object对象";
    }
}

class Person2{
    String name;
    int age;

    //对toString进行重写
    @Override
    public String toString(){
        return name + "，年龄："+ age;
    }

    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }
}