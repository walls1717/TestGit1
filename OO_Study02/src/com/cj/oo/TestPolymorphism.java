package com.cj.oo;

/**
 * 测试多态
 * 要点：
 * 1.多态是方法的多态，不是属性的多态(多态与属性无关)。
 * 2.多态的存在要有3个必要条件：继承，方法重写，父类引用指向子类对象。
 * 3.父类引用指向子类对象后，用该父类引用调用子类重写的方法，此时多态就出现了。
 *
 * @author CJ
 */

public class TestPolymorphism {
    public static void main(String[] args){
        Animal a = new Animal();
        naimalCry(a);
        Animal c = new Cat();
        Animal d = new Dog(); //自动向上转型
        naimalCry(d);

        Dog d2 = (Dog) d; //强制向下转型
        d2.seeDoor();

        String str;

//        Dog d3 = (Dog)c;
//        d3.seeDoor();
    }

    static void naimalCry(Animal a){
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.println("叫了一声！");
    }
}

class Dog extends Animal{
    public void shout(){
        System.out.println("汪汪汪！");
    }
    public void seeDoor(){
        System.out.println("看门中");
    }
}

class Cat extends Animal{
    public void shout(){
        System.out.println("喵喵喵！");
    }
}