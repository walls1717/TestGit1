package com.cj.test.fundamentals6_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author CJ
 */
public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        //再屏幕上打印出这么一段话，并加上当前时间
        System.out.println("At the tone, the time is "
        + Instant.ofEpochMilli(e.getWhen()));
        //根据本地设置发出提示音
        Toolkit.getDefaultToolkit().beep();
    }
}
