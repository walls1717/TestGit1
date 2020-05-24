package com.cj.factory.abstractfactory;

public interface Tyre {
    void revolve();
}

class LuxuryType implements Tyre{

    @Override
    public void revolve() {
        System.out.println("旋转不磨损");
    }
}

class LowType implements Tyre{

    @Override
    public void revolve() {
        System.out.println("磨损快");
    }
}
