package cn.circle.gui;

import javax.swing.*;
import java.awt.*;

/**
 * 容器
 * @version 2020-6-5
 * @author CJ
 */
public class Example3 {
    public static void main(String[] args) {
        var f = new Frame("BorderLayout");
        // 设置窗体中的布局管理器
        f.setLayout(new BorderLayout());
        f.setSize(300, 300);
        f.setLocation(200, 300);
        f.setVisible(true);
        var but1 = new Button("东部");
        var but2 = new Button("西部");
        var but3 = new Button("南部");
        var but4 = new Button("北部");
        var but5 = new Button("中部");

        // 将创建好的按钮添加到窗体中，并设置按钮所在的区域
        f.add(but1, BorderLayout.EAST);
        f.add(but2, BorderLayout.WEST);
        f.add(but3, BorderLayout.SOUTH);
        f.add(but4, BorderLayout.NORTH);
        f.add(but5, BorderLayout.CENTER);
    }
}
