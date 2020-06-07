package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JCheckBox 组件（复选框）
 * @version 2020-6-7
 * @author CJ
 */
public class Example19 extends JFrame {
    public static void main(String[] args) {
        new Example19();
    }

    public Example19() {
        // 创建一个标签，标签文本居中对其
        final var label = new JLabel("CJ欢迎你", JLabel.CENTER);
        label.setFont(new Font("宋体", Font.PLAIN, 20));
        this.add(label);

        var italic = new JCheckBox("ITALIC");
        var bold = new JCheckBox("BOLD");
        var panel = new JPanel();

        panel.add(italic);
        panel.add(bold);

        this.add(panel, BorderLayout.SOUTH);

        // 为两个复选框添加监听器
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode = Font.PLAIN;
                if (italic.isSelected()) {
                    mode += Font.ITALIC;
                }
                if (bold.isSelected()) {
                    mode += Font.BOLD;
                }

                label.setFont(new Font("宋体", mode, 20));
            }
        };

        italic.addActionListener(listener);
        bold.addActionListener(listener);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
