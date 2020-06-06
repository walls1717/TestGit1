package cn.circle.gui;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 键盘监听
 * @version 2020-6-6
 * @author CJ
 */
public class Example13 {
    public static void main(String[] args) {
        var frame = new Frame("KeyEvent");
        frame.setLayout(new FlowLayout());
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);

        // 创建文本框对象
        var textField = new TextField(30);
        frame.add(textField);

        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 返回所按的按键对应的整数值。
                int keyCode = e.getKeyCode();
                String s = KeyEvent.getKeyText(keyCode);
                System.out.println("输入的内容为：" + s + ", ");
                System.out.println("对应的keyCode为：" + keyCode);
            }
        });
    }
}
