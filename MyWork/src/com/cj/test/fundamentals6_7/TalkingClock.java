package com.cj.test.fundamentals6_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @version 2020-5-3
 * @author CJ
 */
public class TalkingClock {
    private final int interval;
    private final boolean beep;

    /**
     *
     * @param interval 表示延迟多长时间
     * @param beep 表示是否发出提示音
     */
    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        //创建内部类对象
        var listener = new TimerPrinter();
        //第一个参数是延迟多少秒，第二个参数是实现的操作
        var timer = new Timer(interval, listener);
        //启动
        timer.start();
    }

    /**
     * 内部类
     * 内用外，随意访问；外用内，需要借助内部类对象
     * 实现了再屏幕上打印一段话，并发出声音
     */
    public class TimerPrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
            if(beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
}
