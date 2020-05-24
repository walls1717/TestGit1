package com.cj.strategy;

public interface Strategy {
    public double getPrice(double standerPrice);
}


class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("不打8折");
        return standerPrice * 0.8;
    }
}

class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("不打8 5折");
        return standerPrice * 0.85;
    }
}

class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("不打9折");
        return standerPrice * 0.9;
    }
}

class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double standerPrice) {
        System.out.println("不打折，原价");
        return standerPrice;
    }
}
