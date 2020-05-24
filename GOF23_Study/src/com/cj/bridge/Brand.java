package com.cj.bridge;

/**
 * 品牌
 * @author CJ
 */

public interface Brand {
    void sale();
}

class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("联想电脑");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("戴尔电脑");
    }
}
class Shenzhou implements Brand{

    @Override
    public void sale() {
        System.out.println("神州电脑");
    }
}
