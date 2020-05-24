package com.cj.factory;

/**
 * @author CJ
 */

public class CarFactory01 {

    private CarFactory01(){
    }

    public static Car createCar(String type) {
        if ("奥迪".equals(type)) {
            return new Audi();
        } else if ("比亚迪".equals(type)) {
            return new Byd();
        } else {
            return null;
        }
    }
}
