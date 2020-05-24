package com.cj.test.fundamentals6_3;

import javax.swing.*;

/**
 * @version 2020-5-2
 * @author CJ
 */
public class TimerTest {
    public static void main(String[] args) {
        var listener = new TimePrinter();

        //第一个参数是时间间隔，单位毫秒数
        //第二个参数是监听器对象
        var timer = new Timer(1000, listener);
        //启动后，就会每间隔一秒，执行一次listener
        //也就是说，每间隔一秒就会提示一段话，并发出提示音
        timer.start();

        /*
        显示一个包含一条提示消息和OK按钮的对话框。
        这个对话框位于parent组件的中央。
        如果parent为null，对话框将显示在屏幕中央。
         */
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
