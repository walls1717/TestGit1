package com.cj.transport;

/**
 * 快递类
 */
public class Send {
    public void send(String local) {
        System.out.println("货物装配");
        System.out.println("开始发货");
        System.out.println("快递发往：" + local);
    }

    public void sendAfter() {
        System.out.println("运输完毕，感谢您的使用");
    }
}
