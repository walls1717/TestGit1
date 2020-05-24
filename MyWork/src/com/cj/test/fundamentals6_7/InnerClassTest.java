package com.cj.test.fundamentals6_7;

import javax.swing.*;

/**
 * 内部类测试
 * @version 2020-5-3
 * @author CJ
 */
public class InnerClassTest {
    public static void main(String[] args) {
        //第一个参数表示延迟1000毫秒
        //第二个参数表示播放声音
        var clock = new TalkingClock(1000, true);
        //调用TalkingClock中的start方法
        clock.start();

        /*
        显示一个包含一条提示消息和OK按钮的对话框。
        这个对话框位于parent组件的中央。
        如果parent为null，对话框将显示在屏幕中央。
        直到用户点击ok程序结束
         */
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
