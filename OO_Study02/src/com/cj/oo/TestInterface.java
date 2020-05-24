package com.cj.oo;

/**
 * 测试接口和实现类
 * @author CJ
 */

public class TestInterface {
    public static void main(String[] args){
        Volant v = new Angel();
        v.fly();

        Honest h = new GoodMan();
        h.helpOther();
    }
}

/**
 * 飞行接口
 */

interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}
//善良接口
interface Honest{
    void helpOther();
}

class Angel implements Volant,Honest{//可以实现多个父接口
    @Override
    public void fly() {
        System.out.println("Flying!");
    }

    @Override
    public void helpOther() {
        System.out.println("Angel.helpOther()");
    }
}

class GoodMan implements Honest{

    @Override
    public void helpOther() {
        System.out.println("GoodMan");
    }
}

class BirdMan implements Volant{

    @Override
    public void fly() {
        System.out.println("BirdMan.fly");
    }
}
