package cn.circle.gui.fruit.tools;

import javax.swing.*;
import java.awt.*;

/**
 * @author CJ
 */
public class GuiTools {

    public static Toolkit kit = Toolkit.getDefaultToolkit();

    public static void center(Component c) {
        int x = (kit.getScreenSize().width - c.getWidth()) / 2;
        int y = (kit.getScreenSize().height - c.getHeight()) / 2;
        c.setLocation(x, y);
    }

    public static void setTitleImage(JFrame frame, String titleIconPath) {
        frame.setIconImage(kit.createImage(titleIconPath));
    }
}
