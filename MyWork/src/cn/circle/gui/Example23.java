package cn.circle.gui;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.*;

/**
 * 弹出式菜单选项
 * @version 2020-6-7
 * @author CJ
 */
public class Example23 extends JFrame {
    public static void main(String[] args) {
        new Example23();
    }

    public Example23() {
        // 创建弹出式菜单
        var popupMenu = new JPopupMenu();
        var refreshItem = new JMenuItem("refresh");
        var createItem = new JMenuItem("create");
        var exitItem = new JMenuItem("exit");

        popupMenu.add(refreshItem);
        popupMenu.add(createItem);
        popupMenu.addSeparator();
        popupMenu.add(exitItem);

        // 添加鼠标监听效果
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

        // 为菜单项添加事件监听
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
