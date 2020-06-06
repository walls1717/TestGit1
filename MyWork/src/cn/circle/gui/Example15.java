package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * JFrame
 * @version 2020-6-6
 * @author CJ
 */
public class Example15 extends JFrame {
    public static void main(String[] args) {
        new Example15();
    }

    public Example15() {
        this.setTitle("JFrameTest");
        this.setSize(250, 300);
        // 定义一个按钮
        JButton button = new JButton("按钮");
        this.setLayout(new FlowLayout());
        this.add(button);
        // 设置点击关闭按钮时的默认操作
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
