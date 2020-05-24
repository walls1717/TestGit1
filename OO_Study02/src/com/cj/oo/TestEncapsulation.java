package com.cj.oo;

/**
 * 测试封装
 * Javabean
 * @author CJ
 */

public class TestEncapsulation {
    public static void main(String[] args){
        Human h = new Human();
//        h.age = 12;
        h.name = "CJ";
        h.height = 24;

        PersonEncapsulation pe = new PersonEncapsulation();
        pe.setAge(14);
        pe.getName();
        System.out.println(pe.getAge());
    }
}

class Boy extends Human{
    void sayHello(){
//        System.out.println(age);//子类无法使用父类私有的属性和方法
    }
}