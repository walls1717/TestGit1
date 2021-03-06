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

    Image plan = GameUtil.getImage("images/plan.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    int planX = 250, planY = 250;

    @Override
    public void paint(Graphics g){//自动被调用。g变量相当于一支画笔
        g.drawImage(bg, 0, 0, null);
        g.drawImage(plan, planX, planY, null);
        planX++;
    }

    //反复的重画窗口
    class PaintThread extends Thread{
        @Override
        public void run() {
            while(true){
                System.out.println("窗口被画一次！");
                repaint(); //重画

                try {
                    Thread.sleep(40); //1s=1000ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
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
        this.setLocation(300, 300);

        //增加窗口关闭监听，这样用户可以通过右上角的关闭按钮关闭程序
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();//启动重画窗口的线程
    }

    public static void main(String[] args){
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
