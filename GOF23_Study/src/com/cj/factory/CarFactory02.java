package com.cj.factory;

/**
 * 简单工厂
 *
 * @author CJ
 */

public class CarFactory02 {

    private CarFactory02() {
    }

    public static Car createAudi() {
        return new Audi();
    }

    public static Car createByd() {
        return new Byd();
    }
}
