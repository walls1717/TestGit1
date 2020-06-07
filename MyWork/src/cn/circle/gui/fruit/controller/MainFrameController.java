package cn.circle.gui.fruit.controller;

import cn.circle.gui.fruit.service.AbstractMainFrame;

/**
 * 欢迎界面按钮操作界面
 * @author CJ
 */
public class MainFrameController extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        new AdminDialogController(this, true).setVisible(true);
    }
}
