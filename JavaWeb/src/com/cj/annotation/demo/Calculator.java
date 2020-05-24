package com.cj.annotation.demo;

/**
 * 计算器
 * @version 2020-5-21
 * @author CJ
 */
public class Calculator {

    @Check
    public void add() {
        String str = null;
        str.toString();
        System.out.println("1 + 0 = " + (1 + 0));
    }

    @Check
    public void sub() {
        System.out.println("1 - 0 = " + (1 - 0));
    }

    @Check
    public void mul() {
        System.out.println("1 * 0 = " + (1 * 0));
    }

    @Check
    public void div() {
        System.out.println("1 / 0 = " + (1 / 0));
    }

    public void show() {
        System.out.println("show!!");
    }
}
