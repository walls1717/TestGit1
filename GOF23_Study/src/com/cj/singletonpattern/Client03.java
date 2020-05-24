package com.cj.singletonpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种创建单列模式的效率
 *
 * @author CJ
 */

@SuppressWarnings("all")
public class Client03 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        //启动十个线程
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000; i++) {
                        Object o = SingletonDemo01.getInstance();
//                        Object o = SingletonDemo05.INSTANCE;
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await(); //main线程阻塞，知道计数器变为0，才会继续往下执行。
        long end = System.currentTimeMillis();
        System.out.println("总耗时："+(end-start));
    }
}
