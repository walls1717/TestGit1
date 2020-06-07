package cn.circle.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 表格
 * @version 2020-6-7
 * @author CJ
 */
public class Example24 extends JFrame {
    public static void main(String[] args) {
        new Example24();
    }

    public Example24() {
        init();
    }

    public void init() {
        // 创建表格
        Object[] columnTitle = {"Name", "Age", "Sex"};
        Object[][] rowData = {
                new Object[] {"CJ", "1", "n"},
                new Object[] {"asd", "2", "23"},
                new Object[] {"23", "23", "b"},
                new Object[] {"234", "234", "2"},
        };
        var table = new JTable(rowData, columnTitle);
        // 添加表格组件到窗体中
        this.add(new JScrollPane(table));
        // 设置自适应窗体大小
        this.pack();
        this.setTitle("简单表格");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
