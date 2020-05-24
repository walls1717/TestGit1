package com.cj.jvm.dynamiccomplie.thread;

/**
 * 静态代理
 * 公共接口：
 * 1.真是角色
 * 2.代理角色
 *
 * @author CJ
 */

public class StaticProxy {
    public static void main(String[] args){
        new WeddingCompany(new You()).happyMarry();

//        new Thread(线程对象).start();
    }
}

interface Marry {
    void happyMarry();
}

//真是角色
class You implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("you and 嫦娥终于奔月了...");
    }
}

//代理角色
class WeddingCompany implements Marry {
    //真是角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready(){
        System.out.println("布置猪窝...");
    }
    private void after(){
        System.out.println("闹玉兔...");
    }
}
