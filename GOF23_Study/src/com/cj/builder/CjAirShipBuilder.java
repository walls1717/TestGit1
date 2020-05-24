package com.cj.builder;

public class CjAirShipBuilder implements AirShipBuilder{ //StringBuilder, JDmDomBuilder, SaxBuilder
    @Override
    public Engine builderEngine() {
        System.out.println("构建CJ牌发动机");
        return new Engine("CJ牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建轨道舱");
        return new OrbitalModule("CJ牌轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建逃逸塔");
        return new EscapeTower("CJ牌逃逸塔");
    }
}
