package cn.circle.gui;

import java.awt.*;

/**
 * 网格布局管理器
 * @version 2020-6-5
 * @author CJ
 */
public class Example4 {
    public static void main(String[] args) {
        var frame = new Frame("GridLayout");
        frame.setLayout(new GridLayout(3, 3));
        frame.setSize(300, 300);
        frame.setLocation(400, 300);
        // 循环添加 9 个按钮
        for (int i = 1; i <= 9; i++) {
            var button = new Button("button" + i);
            frame.add(button);
        }
        frame.setVisible(true);
    }
}
