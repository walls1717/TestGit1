package com.cj.adapter;

/**
 * 适配器(类适配方式)
 * @author CJ
 */

public class Adapter extends Adaptee implements Target {

    @Override
    public void handleReq() {
        super.request();
    }
}
