package com.cj.jvm.dynamiccomplie.others;

import java.util.*;

/**
 * 任务调度：Timer和TimerTask类
 *
 * @author CJ
 */

public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //执行安排
//        timer.schedule(new MyTask(), 1000); //执行任务一次
//        timer.schedule(new MyTask(), 1000, 200);//执行多次
        Calendar cal = new GregorianCalendar(2020,4,1,16,48,40);
        timer.schedule(new MyTask(), cal.getTime(),200);//指定时间
    }
}

//任务类
class MyTask extends TimerTask {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("放空大脑休息一会");
        }
        System.out.println("--------------end-------------");
    }
}
