package cn.circle.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 鼠标事件
 * @version 2020-6-6
 * @author CJ
 */
public class Example12 {
    public static void main(String[] args) {
        var frame = new Frame("MouseEvent");
        // 窗口布局
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 400);
        frame.setLocation(300, 400);
        frame.setVisible(true);

        // 添加按钮
        var button = new Button("Button");
        frame.add(button);

        // 为按钮添加鼠标事件监听器
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked：鼠标点击事件");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed：鼠标按下事件");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased：鼠标放开事件");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("MouseEvent：鼠标进入区域事件");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited：鼠标移除按钮区域事件");
            }
        });
    }
}
