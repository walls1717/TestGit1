package cn.circle.gui.fruit.service;

import cn.circle.gui.fruit.tools.GuiTools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 欢迎界面
 * @author CJ
 */
public abstract class AbstractMainFrame extends JFrame {

    private JLabel titleLabel = new JLabel(new ImageIcon("D:/intellij IDEA/Test/MyWork/src/cn/circle/gui/fruit/image/bac.jpg"));
    private JButton btn = new JButton("进入系统");

    public AbstractMainFrame() {
        // 初始化界面
        this.init();
        // 添加组件
        this.addComponent();
        // 添加事件监听
        this.addListener();
    }

    private void init() {
        this.setTitle("水果超市欢迎你");
        this.setSize(600, 400);
        // 窗口的位置，在屏幕中央
        GuiTools.center(this);
        // 设置窗口的小图标
        GuiTools.setTitleImage(this, "D:/intellij IDEA/Test/MyWork/src/cn/circle/gui/fruit/image/icon.jpg");

        // 固定窗口大小
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent() {
        // 窗体使用默认的边界布局，北区放入图片
        this.add(titleLabel, BorderLayout.NORTH);
        // 创建 JP 面板
        JPanel btnPanel = new JPanel();
        // 设置面板的布局方式为没有布局管理器
        btnPanel.setLayout(null);
        // 设置按钮的位置与大小
        btn.setBounds(240, 20, 120, 50);

        btnPanel.add(btn);
        // 添加面板到窗体
        this.add(btnPanel);
    }

    private void addListener() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 展示管理员界面
                showAdminDialog();
            }
        });
    }

    public abstract void showAdminDialog();
}
