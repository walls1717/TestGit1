package com.cj.jvm.dynamiccomplie.syn;

/**
 * 线程安全：在并发时保证数据正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author CJ
 */

public class SynTest01 {
    public static void main(String[] args) {
        //一份资源多个代理
        SafeWeb12306 web = new SafeWeb12306();
        //多个代理
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蝗").start();
    }
}

class SafeWeb12306 implements Runnable {
    //票数
    private int ticketNumber = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }
    //线程安全 同步
    public synchronized void test(){
        if (ticketNumber <= 0) {
            flag = false;
            return ;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
    }
}

