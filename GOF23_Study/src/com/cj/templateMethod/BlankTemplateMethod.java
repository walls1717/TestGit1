package com.cj.templateMethod;

public abstract class BlankTemplateMethod {
    public void takeNumber(){
        System.out.println("取号排队");
    }

    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){ //模板方法
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
