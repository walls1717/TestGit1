package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JDialog 对话框
 * @version 2020-6-6
 * @author CJ
 */
public class Example16 {
    public static void main(String[] args) {
        var button = new JButton("模式对话框");
        var button2 = new JButton("非模式对话框");
        var frame = new JFrame("DialogDemo");
        frame.setSize(300, 250);
        frame.setLocation(300, 200);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.add(button2);

        // 设置点击关闭按钮的模式关闭窗口操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // 创建 JDialog
        final var dialog = new JDialog(frame, "Dialog");
        dialog.setSize(220, 150);
        dialog.setLocation(350, 150);
        dialog.setLayout(new FlowLayout());
        var button3 = new JButton("确定");
        dialog.add(button3);
        final var label = new Label("标签");
        dialog.add(label);

        // 为 模式对话框 按钮添加点击事件操作。
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置对话框的状态为模式对话框
                dialog.setModal(true);
                // 修改标签内容
                label.setText("click close");

                dialog.setVisible(true);
            }
        });

        // 为 非模式对话框 按钮添加点击事件操作。
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 设置对话框的状态为模式对话框
                dialog.setModal(false);
                // 修改标签内容
                label.setText("click close");

                dialog.setVisible(true);
            }
        });

        // 为对话框中的按钮添加点击事件
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }
}
