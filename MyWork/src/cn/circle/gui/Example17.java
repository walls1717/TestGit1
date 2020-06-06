package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 中间容器添加按钮
 * @version 2020-6-6
 * @author CJ
 */
public class Example17 extends JFrame {
    public static void main(String[] args) {
        new Example17();
    }

    public Example17() {
        JPanel panel = new JPanel();
        panel.add(new JButton("按钮1"));
        panel.add(new JButton("按钮2"));
        panel.add(new JButton("按钮3"));
        panel.add(new JButton("按钮4"));

        // 创建一个滚动面板
        JScrollPane scrollPane = new JScrollPane();
        // 设置水平滚动条一直显示
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // 设置垂直滚动条，需要时显示
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        // 设置 panel 面板在滚动面板中显示
        scrollPane.setViewportView(panel);

        // 将面板 panel 添加到窗体中
        this.add(scrollPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 250);
        this.setVisible(true);
    }
}
