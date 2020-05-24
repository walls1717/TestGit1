package com.cj.jvm.dynamiccomplie.thread;

import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑
 * 使用Callable接口
 *
 * @author CJ
 */

public class CRacer implements Callable<Integer> {
    private static String winner;//胜利者


    public Integer call() throws Exception {
        for (int steps = 1; steps <= 100; steps++) {
            //模拟休息
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps % 10 == 0) {
                Thread.sleep(100);
            }

            System.out.println(Thread.currentThread().getName() + "--->" + steps);
            //比赛是否结束
            boolean flag = gameOver(steps);
            if (flag) {
                return steps;
            }
        }
        return null;
    }

    private boolean gameOver(int steps) {
        if (winner != null) { //存在胜利者
            return true;
        } else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winnner-->" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);
        //提交执行
        Future<Integer> result1 = ser.submit(racer);
        Future<Integer> result2 = ser.submit(racer);
        //获取结果
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + "--->" + r2);
        //关闭服务
        ser.shutdown();
    }
}
