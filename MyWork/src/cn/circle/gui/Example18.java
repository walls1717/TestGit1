package cn.circle.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 文本组件 JTextField 和 JTextArea 组件的使用
 * @version 2020-6-7
 * @author CJ
 */
public class Example18 extends JFrame {
    public static void main(String[] args) {
        new Example18();
    }

    public Example18() {
        this.setLayout(new BorderLayout());
        this.setTitle("聊天窗口");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea chatContent = new JTextArea(12, 34);
        JScrollPane showPanel = new JScrollPane(chatContent);
        chatContent.setEditable(false);
        // 添加面板到滚动面板
        this.add(showPanel, BorderLayout.CENTER);
        // 创建一个标签
        Label label = new Label("Message");
        final JTextField inputField = new JTextField(20);
        JButton sendBt = new JButton("Send");
        // 创建一个面板，用来存放下面的组件
        JPanel inputPanel = new JPanel();
        inputPanel.add(label);
        inputPanel.add(inputField);
        inputPanel.add(sendBt);
        // 添加下面的面板到窗口中
        this.add(inputPanel, BorderLayout.SOUTH);
        // 为按钮添加事件
        sendBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = inputField.getText();
                if(content != null && !content.trim().equals("")) {
                    // 如果内容不为空，将输入的文本追加到聊天窗体中
                    chatContent.append("Myself：" + content + "\n");
                } else {
                    // 如果为空，提示聊天信息不为空
                    chatContent.append("聊天信息不能为空" + "\n");
                }
                // 将文本框内容设置为空
                inputField.setText("");
            }
        });
        this.setVisible(true);
    }
}
