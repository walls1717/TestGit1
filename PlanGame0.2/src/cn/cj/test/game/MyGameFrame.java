package cn.cj.test.game;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏的主窗口
 * @author CJ
 */

public class MyGameFrame extends JFrame {

    Image ball = GameUtil.getImage("images/ball.png");

    public void paint(Graphics g){//自动被调用。g变量相当于一支画笔
        Color c = g.getColor();
        Font f = g.getFont();
        g.setColor(Color.BLUE);

        g.drawLine(100, 100, 300, 300);
        g.drawRect(100, 100, 300, 300);
        g.drawOval(100, 100, 300, 300);
        g.fillRect(100, 100, 40, 40);
        g.setColor(Color.RED);
        g.setFont(new Font("宋体", Font.BOLD, 50));
        g.drawString("我是谁？", 200, 200);

        g.drawImage(ball, 250, 250, null);

        g.setColor(c);
        g.setFont(f);
    }

    /**
     * 初始化窗口
     */
    public void launchFrame(){
        //在游戏窗口打印标题
        this.setTitle("程杰的飞机大战游戏");
        //默认为不显示窗口，设为可见
        this.setVisible(true);
        //设置窗口的大小
        this.setSize(500, 500);
        //设置左上角的顶点坐标
        this.setLocation(300, 250);

        //增加窗口关闭监听，这样用户可以通过右上角的关闭按钮关闭程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
