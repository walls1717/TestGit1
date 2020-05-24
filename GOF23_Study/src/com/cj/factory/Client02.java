package com.cj.factory;

/**
 * 简单工厂情况下
 *
 * @author CJ
 */

public class Client02 { //调用者
    public static void main(String[] args) {
        Car c1 = CarFactory01.createCar("奥迪");
        Car c2 = CarFactory01.createCar("比亚迪");
        c1.run();
        c2.run();
    }
}
