package cn.circle.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @version 2020-6-5
 * @author CJ
 */
public class Example6 {
    public static void main(String[] args) {
        Layout2 Layout2 = new Layout2();
    }
}

class Layout2 extends Frame implements ActionListener {
    CardLayout cardLayout = new CardLayout();
    Panel cardPanel = new Panel();
    Panel controlPanel = new Panel();
    Button preButton;
    Button nextButton;

    public Layout2() {
        this.setSize(300, 200);
        cardPanel.setLayout(cardLayout);
        cardPanel.add(new Label("FirstCard", Label.CENTER));
        cardPanel.add(new Label("SecondCard", Label.CENTER));
        cardPanel.add(new Label("ThirdCard", Label.CENTER));

        // 创建两个按钮
        nextButton = new Button("nextCard");
        preButton = new Button("preCard");
        // 将按钮添加面板
        controlPanel.add(preButton);
        controlPanel.add(nextButton);

        // 把面板添加到窗体中
        this.add(cardPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);

        nextButton.addActionListener(this);
        preButton.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Layout2.this.dispose();
            }
        });

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == nextButton) {
            // 切换 cardPanel 面板当前的卡片向后切换一张
            cardLayout.next(cardPanel);
        }
        if(e.getSource() == preButton) {
            cardLayout.previous(cardPanel);
        }
    }
}
