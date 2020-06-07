package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JRadioButton 组件（单选）
 * @version 2020-6-7
 * @author CJ
 */
public class Example20 extends JFrame {
    public static void main(String[] args) {
        new Example20();
    }

    public Example20() {
        final var pallet = new JPanel();
        this.add(pallet, BorderLayout.CENTER);

        var group = new ButtonGroup();
        var btn1 = new JRadioButton("灰");
        var btn2 = new JRadioButton("粉");
        var btn3 = new JRadioButton("黄");

        group.add(btn1);
        group.add(btn2);
        group.add(btn3);

        var panel = new JPanel();
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);

        // 添加面板到窗体下方
        this.add(panel, BorderLayout.SOUTH);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color = null;
                if (btn1.isSelected()) {
                    color = Color.GRAY;
                } else if (btn2.isSelected()){
                    color = Color.PINK;
                } else if (btn3.isSelected()) {
                    color = Color.YELLOW;
                }
                // 为调色板设置背景颜色
                pallet.setBackground(color);
            }
        };
        btn1.addActionListener(listener);
        btn2.addActionListener(listener);
        btn3.addActionListener(listener);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
