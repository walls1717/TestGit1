package cn.cj.test.game;


import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 飞机游戏的主窗口
 * @author CJ
 */

public class MyGameFrame extends JFrame {

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
