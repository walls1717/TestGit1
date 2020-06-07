package cn.circle.gui.fruit.test;

import cn.circle.gui.fruit.service.AbstractMainFrame;

/**
 * 主界面测试类
 * @author CJ
 */
public class AbstractMainFrameTest extends AbstractMainFrame {
    public static void main(String[] args) {
        new AbstractMainFrameTest().setVisible(true);
    }

    @Override
    public void showAdminDialog() {
        System.out.println("进入到管理员界面");
    }
}
