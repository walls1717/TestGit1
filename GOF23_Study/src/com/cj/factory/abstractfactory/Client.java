package com.cj.factory.abstractfactory;

/**
 * @author CJ
 */

public class Client {
    public static void main(String[] args) {
        CarFactory factory = new LuxuryCarFactory();
        Engine e = factory.createEngine();
        e.run();
        e.start();
    }
}
