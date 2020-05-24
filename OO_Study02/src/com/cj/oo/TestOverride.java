package com.cj.oo;

/**
 * 测试方法的重写override
 * 子类通过重写父类的方法，可以用自身的行为替换父类的行为
 *
 * 1.方法名、形参列表相同
 * 2.返回值类型和声明异常类型，子类小于父类
 * 3.访问权限，子类大于等于父类
 */

public class TestOverride {
    public static void main(String[] args){
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Horse();
        Vehicle v3 = new Plane();
        v1.run();
        v2.run();
        v3.run();
        v2.stop();
        v3.stop();
    }

}

class Vehicle{
    public void run(){
        System.out.println("run....");
    }

    public void stop(){
        System.out.println("STOP!");
    }
}

class Horse extends Vehicle{//继承父类Vehicle
    //对父类中的run进行重写
    public void run(){
        System.out.println("runnnn.....!");
    }
}

//继承父类vehicle
class Plane extends Vehicle {
    //对父类中的run重写
    public void run(){
        System.out.println("天上飞！");
    }
    //对父类中的stop重写
    public void stop(){
        System.out.println("空中不能停，坠机了！");
    }
}
