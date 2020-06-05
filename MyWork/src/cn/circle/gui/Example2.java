package cn.circle.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 容器
 * @version 2020-6-5
 * @author CJ
 */
public class Example2 {
    public static void main(String[] args) {
        // 创建窗口
        Frame f = new Frame("FlowLayout");
        // 设置窗体中的布局管理器
        f.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
        f.setSize(220, 300);
        f.setLocation(200, 300);
        // 把按钮添加到 f 窗口中
        f.add(new JButton("按钮1"));

        f.setVisible(true);
    }
}
