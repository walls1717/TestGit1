package com.cj.templateMethod;

public class Client {
    public static void main(String[] args) {
        BlankTemplateMethod btm = new DrawMoney();
        btm.process();

        //采用匿名内部类
        BlankTemplateMethod btm2 = new BlankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        btm2.process();

        BlankTemplateMethod btm3 = new BlankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要理财！我有一千万");
            }
        };
        btm3.process();
    }
}

class DrawMoney extends BlankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("我要取款");
    }
}
