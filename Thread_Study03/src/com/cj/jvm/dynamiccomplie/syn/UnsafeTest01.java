package com.cj.jvm.dynamiccomplie.syn;

/**
 * 线程不安全：数据有负数、相同
 * @author CJ
 */

public class UnsafeTest01 {
    public static void main(String[] args) {
        //一份资源多个代理
        UnsafeWeb12306 web = new UnsafeWeb12306();
        //多个代理
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蝗").start();
    }
}

class UnsafeWeb12306 implements Runnable {
    //票数
    private int ticketNumber = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            test();
        }
    }
    public void test(){
        if (ticketNumber < 0) {
            flag = false;
            return ;
        }
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
    }
}

