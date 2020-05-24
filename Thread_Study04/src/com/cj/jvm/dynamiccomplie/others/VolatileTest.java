package com.cj.jvm.dynamiccomplie.others;

/**
 * volatile用于保证数据的同步，也就是可见性
 *
 * @author CJ
 */

public class VolatileTest {
    private volatile static int num = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0) { //此处不要编写代码

            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }
}
