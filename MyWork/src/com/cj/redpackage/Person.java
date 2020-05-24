package com.cj.redpackage;

/**
 * 每一个人都有名字，余额
 * @version 2020-5-4
 * @author CJ
 */
public class Person {
    /**
     * 表示名称
     */
    private String name;
    /**
     * 表示余额
     */
    private int balance;

    public Person(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }
}
