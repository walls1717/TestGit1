package com.cj.jvm.dynamiccomplie.syn;

/**
 * 线程安全：在并发时保证数据正确性，效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 *
 * @author CJ
 */

public class SynBlockTest03 {
    public static void main(String[] args) {
        //一份资源多个代理
        SynWeb12306 web = new SynWeb12306();
        //多个代理
        new Thread(web, "码畜").start();
        new Thread(web, "码农").start();
        new Thread(web, "蚂蝗").start();
    }
}

class SynWeb12306 implements Runnable {
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
            test5();
        }
    }

    //线程安全：尽可能锁定合理的范围(不是指代码 指数据的完整性)
    //double checking
    public synchronized void test5() {
        if (ticketNumber <= 0) { //考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {
            if (ticketNumber <= 0) { //考虑的是最后一张票
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
        }
    }

    //线程不安全 范围太小锁不住
    public void test4() {
        synchronized (this) {
            if (ticketNumber <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
    }

    //锁定失败 线程不安全 ticketNumber对象在变
    public synchronized void test3() {
        synchronized ((Integer) ticketNumber) {
            if (ticketNumber <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
        }
    }

    //线程安全 范围太大 --> 效率低下
    public synchronized void test2() {
        synchronized (this) {
            if (ticketNumber <= 0) {
                flag = false;
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
        }
    }

    //线程安全 同步
    public synchronized void test1() {
        if (ticketNumber <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "--->" + ticketNumber--);
    }
}

