package cn.circle.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 用匿名内部类实现事件处理
 * @version 2020-6-5
 * @author CJ
 */
public class Example10 {
    public static void main(String[] args) {
        var frame = new Frame("我的窗体");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        var button = new Button("EXIT");
        frame.add(button);

        // 用内部类的方式为按钮注册监听器
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
    }
}
