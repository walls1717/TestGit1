package com.cj.builder;

public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new CjAirShipDirector(new CjAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        ship.launch();
    }
}
