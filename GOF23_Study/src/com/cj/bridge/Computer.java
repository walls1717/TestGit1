package com.cj.bridge;


public interface Computer {
    void sale();
}

class Desktop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售台式机");
    }
}

class Laptop implements Computer{

    @Override
    public void sale() {
        System.out.println("销售笔记本");
    }
}

class Pad implements Computer{

    @Override
    public void sale() {
        System.out.println("销售平板电脑");
    }
}

//联想
class LenovoDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售联想台式机");
    }
}

class LenovoLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}

class LenovoDestop extends Pad{
    @Override
    public void sale() {
        System.out.println("销售联想平板");
    }
}

//神州
class ShenzhouDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售神州台式机");
    }
}

class ShenzhouLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售神州笔记本");
    }
}

class ShenzhouDestop extends Pad{
    @Override
    public void sale() {
        System.out.println("销售神州平板");
    }
}

//戴尔
class DellDesktop extends Desktop{
    @Override
    public void sale() {
        System.out.println("销售戴尔台式机");
    }
}

class DellLaptop extends Laptop{
    @Override
    public void sale() {
        System.out.println("销售戴尔笔记本");
    }
}

class DellDestop extends Pad{
    @Override
    public void sale() {
        System.out.println("销售戴尔平板");
    }
}