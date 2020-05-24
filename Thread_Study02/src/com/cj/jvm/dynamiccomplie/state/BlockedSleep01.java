package com.cj.jvm.dynamiccomplie.state;

/**
 * sleep模拟网络延时，放大了发生问题的可能性
 *
 * @author CJ
 */

public class BlockedSleep01 {
    public static void main(String[] args) {
        //一份资源多个代理
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蝗").start();
    }
}

class Web12306 implements Runnable {
    //票数
    private int ticketNumber = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNumber < 0) {
                break;
            }
            //模拟网络延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
        }
    }
}
