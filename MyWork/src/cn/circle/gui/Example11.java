package cn.circle.gui;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 窗口事件
 * @version 2020-6-6
 * @author CJ
 */
public class Example11 {
    public static void main(String[] args) {
        var frame = new Frame("WindowEvent");
        frame.setSize(400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        // 使用内部类创建 WindowListener 对象，监听窗体事件
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened：窗体打开事件");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing：窗体正在关闭事件");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed：窗体已经关闭事件");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified：窗口图表化事件");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified窗口取消图表化事件");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated：窗体激活事件");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated窗口停用事件");
            }
        });
    }
}
