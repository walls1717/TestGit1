package com.cj.jvm.dynamiccomplie.syn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 线程安全：操作并发容器
 *
 * @author CJ
 */

public class SynContainer {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                //同步块
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(100);
        System.out.println(list.size());
    }
}