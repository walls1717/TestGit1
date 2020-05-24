package com.cj.mediator;

public class Finacial implements Department {

    private Mediator m;

    public Finacial(Mediator m) {
        this.m = m;
        m.register("finacial", this);
    }

    @Override
    public void selfAction() {
        System.out.println("提供资金支持");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，钱太多了，怎么花");
    }
}
