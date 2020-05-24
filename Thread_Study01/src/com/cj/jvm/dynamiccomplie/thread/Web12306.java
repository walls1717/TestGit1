package com.cj.jvm.dynamiccomplie.thread;

/**
 * 共享资源，并发（线程安全）
 *
 * @author CJ
 */

public class Web12306 implements Runnable {
    //票数
    private int ticketNumber = 99;

    @Override
    public void run() {
        while (true) {
            if (ticketNumber < 0) {
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
        }
    }

    public static void main(String[] args) {
        //一份资源多个代理
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蝗").start();
    }
}
