package com.cj.test.fundamentals6_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 *
 * @version 2020-5-7
 * @author CJ
 */
public class TalkingClock {
    public void start(int interval, boolean beep) {
        //匿名内部类
        var listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("At the tone, the time is " + Instant.ofEpochMilli(event.getWhen()));
                if(beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        };
        var timer = new Timer(interval, listener);
        timer.start();
    }
}
