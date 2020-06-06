package cn.circle.gui;

import java.awt.*;
import java.util.Random;

/**
 * AWT 绘图
 * @version 2020-6-6
 * @author CJ
 */
public class Example14 {
    public static void main(String[] args) {
        var frame = new Frame("验证码");
        Panel panel = new MyPanel();
        frame.add(panel);
        frame.setSize(200, 100);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class MyPanel extends Panel {
    @Override
    public void paint(Graphics g) {
        int width = 160;
        int height = 40;
        // 设置画笔的颜色
        g.setColor(Color.LIGHT_GRAY);
        // 绘制验证码背景
        g.fillRect(0, 0, width - 1, height - 1);
        // 设置画笔颜色
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, width, height);

        // 绘制干扰点
        var random = new Random();
        for (int i = 0; i < 100; i++) {
            int x = random.nextInt(width) - 2;
            int y = random.nextInt(height) - 2;
            g.drawOval(x, y, 2, 2);
        }

        // 设置验证码字体
        g.setFont(new Font("黑体", Font.BOLD, 30));
        // 设置验证码文字颜色
        g.setColor(Color.BLUE);
        // 产生随机验证码
        char[] chars = "0123456789qwertyuiopasdfghjklzxcvbnm".toCharArray();
        var sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            int pos = random.nextInt(chars.length);
            char c = chars[pos];
            sb.append(c + " ");
        }

        // 绘制文字
        g.drawString(sb.toString(), 20, 30);
    }
}
