package cn.circle.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 使用适配器
 * @version 2020-6-5
 * @author CJ
 */
public class Example9 {
    public static void main(String[] args) {
        var frame = new Frame("我的窗体");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame.addWindowListener(new MyWindowListener2());
    }
}

class MyWindowListener2 extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        var window = (Window) e.getComponent();
        window.dispose();
    }
}
