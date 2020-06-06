package cn.circle.gui;

import java.awt.*;

/**
 * 不使用布局管理器
 * @version 2020-6-5
 * @author CJ
 */
public class Example7 {
    public static void main(String[] args) {
        var frame = new Frame("不使用布局管理器");
        frame.setLayout(null);
        frame.setSize(300, 150);
        var button1 = new Button("press");
        var button2 = new Button("pop");
        // 设置按钮显示的位置与大小
        button1.setBounds(40, 60, 100, 30);
        button2.setBounds(140, 90, 100, 30);
        // 添加按钮到窗口
        frame.add(button1);
        frame.add(button2);
        frame.setVisible(true);
    }
}
