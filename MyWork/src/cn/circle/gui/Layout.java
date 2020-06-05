package cn.circle.gui;

import java.awt.*;

public class Layout extends Frame {
    public Layout(String title) {
        GridBagLayout layout = new GridBagLayout();
        // 约束对象
        var c = new GridBagConstraints();
        // 设置布局管理器
        this.setLayout(layout);
        c.fill = GridBagConstraints.BOTH;
        // 设置横向权重为 1
        c.weightx = 1;
        c.weighty = 1;
        // 增加组件
        this.addComponent("btn1", layout, c);
        this.addComponent("btn2", layout, c);
        this.addComponent("btn3", layout, c);
        // 添加的组件时本行最后一个组件
        c.gridwidth = GridBagConstraints.REMAINDER;
        this.addComponent("btn4", layout, c);

        c.weightx = 0;
        c.weighty = 0;
        this.addComponent("btn5", layout, c);

        c.gridwidth = 1;
        this.addComponent("btn6", layout, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        this.addComponent("btn7", layout, c);

        // 设置组件跨两个网格
        c.gridheight = 2;
        c.gridwidth = 1;
        c.weightx = 2;
        c.weighty = 2;
        this.addComponent("btn8", layout, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        c.gridheight = 1;
        this.addComponent("btn9", layout, c);
        this.addComponent("btn10", layout, c);

        this.setTitle(title);
        this.pack();
        this.setVisible(true);
    }

    public void addComponent(String name, GridBagLayout layout, GridBagConstraints c) {
        var bt = new Button(name);
        // 设置约束对象和按钮的关联
        layout.setConstraints(bt, c);
        this.add(bt);
    }
}
