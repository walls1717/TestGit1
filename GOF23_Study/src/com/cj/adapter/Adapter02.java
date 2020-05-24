package com.cj.adapter;

/**
 * 适配器(对象适配器，使用了组合的方式跟被适配对象整合)
 * @author CJ
 */

public class Adapter02 implements Target {

    private Adaptee adaptee;

    @Override
    public void handleReq() {
        adaptee.request();
    }

    public Adapter02(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
}
