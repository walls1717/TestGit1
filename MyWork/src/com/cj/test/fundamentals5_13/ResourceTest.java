package com.cj.test.fundamentals5_13;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @version 2020-5-20
 * @author CJ
 */
public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Class<?> cl = ResourceTest.class;

        URL aboutURL = cl.getResource("about.gif");
        var icon = new ImageIcon(aboutURL);

        InputStream stream = cl.getResourceAsStream("data/about.txt");
        var about = new String(stream.readAllBytes(), "UTF-8");

        InputStream stream2 = cl.getResourceAsStream("/corejava/title.txt");
        var title = new String(stream2.readAllBytes(), "UTF-8").trim();

        JOptionPane.showMessageDialog(null, about, title, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
