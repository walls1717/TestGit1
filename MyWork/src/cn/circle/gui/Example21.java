package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JComboBox 组件
 * @version 2020-6-7
 * @author CJ
 */
public class Example21 extends JFrame {
    public static void main(String[] args) {
        new Example21();
    }

    public Example21() {
        var panel = new JPanel();
        // 创建下拉列表框
        var comboBox = new JComboBox<String>();
        comboBox.addItem("请选择城市");
        comboBox.addItem("北京");
        comboBox.addItem("天津");
        comboBox.addItem("南京");
        comboBox.addItem("上海");
        comboBox.addItem("重庆");

        // 创建一个文本框
        var field = new JTextField(20);

        panel.add(comboBox);
        panel.add(field);

        this.add(panel);

        this.setSize(350, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // 为下拉列表框添加事件监听器
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = (String) comboBox.getSelectedItem();
                if ("请选择城市".equals(item)) {
                    field.setText("");
                } else {
                    field.setText("您选择的城市是：" + item);
                }
            }
        });
    }
}
