package com.cj.test.fundamentals6_8;

import javax.swing.*;

/**
 * 测试匿名内部类
 * 当接口的实现类（或者是父类的子类）只需要使用一次，
 * 那么这种情况下就可以省略掉这个类的定义
 * @version 2020-5-7
 * @author CJ
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
