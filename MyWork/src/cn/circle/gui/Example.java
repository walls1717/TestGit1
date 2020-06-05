package cn.circle.gui;

import java.awt.*;

/**
 * 测试窗口
 * @version 2020-6-5
 * @author CJ
 */
public class Example {
    public static void main(String[] args) {
        // 创建窗口
        Frame f = new Frame("我的窗体");
        // 设置窗口大小
        f.setSize(400, 300);
        // 设置窗口初始位置
        f.setLocation(300, 200);

        f.setVisible(true);
    }
}
