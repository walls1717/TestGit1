package com.cj.builder;

public class CjAirShipDirector implements AirShipDirector {
    private AirShipBuilder builder;

    public CjAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine e = builder.builderEngine();
        OrbitalModule o = builder.builderOrbitalModule();
        EscapeTower et = builder.builderEscapeTower();

        //装配乘飞船对象
        AirShip ship = new AirShip();
        ship.setEngine(e);
        ship.setOrbitalModule(o);
        ship.setEscapeTower(et);
        return ship;
    }
}
