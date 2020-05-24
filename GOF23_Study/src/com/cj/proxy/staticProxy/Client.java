package com.cj.proxy.staticProxy;

public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);

        proxy.confer();
        proxy.singContract();
        proxy.bookTicket();
        proxy.sing(); //此处调用了真实角色唱歌

        proxy.collectMoney();
    }
}
