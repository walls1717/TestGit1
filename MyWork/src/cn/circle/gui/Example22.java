package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 菜单选项
 * @version 2020-6-7
 * @author CJ
 */
public class Example22 extends JFrame {
    public static void main(String[] args) {
        new Example22();
    }

    public Example22() {
        // 创建菜单栏
        var menuBar = new JMenuBar();
        var menu = new JMenu("操作");
        var item1 = new JMenuItem("弹出窗口");
        var item2 = new JMenuItem("关闭");

        menu.add(item1);
        // 添加分隔符
        menu.addSeparator();
        menu.add(item2);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = new JDialog(Example22.this, true);
                dialog.setTitle("弹出对话框");
                dialog.setSize(200, 200);
                dialog.setLocation(50, 50);
                dialog.setVisible(true);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
