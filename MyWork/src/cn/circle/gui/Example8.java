package cn.circle.gui;

import org.w3c.dom.css.CSSPrimitiveValue;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 窗口关闭
 * @version 2020-6-5
 * @author CJ
 */
public class Example8 {
    public static void main(String[] args) {
        var frame = new Frame("我的窗体");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        // 为窗口组件注册监听器
        frame.addWindowListener(new MyWindowListener());
    }
}

class MyWindowListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Window window = e.getWindow();
        window.setVisible(false);
        window.dispose();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
