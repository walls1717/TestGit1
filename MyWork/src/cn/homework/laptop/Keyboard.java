package cn.homework.laptop;

/**
 * 键盘
 * 实现输入功能
 * @version 2020-5-5
 * @author CJ
 */
public class Keyboard implements Usb {
    @Override
    public void powerOn() {
        System.out.println("键盘连接");
    }

    @Override
    public void powerOff() {
        System.out.println("键盘关闭");
    }

    /**
     * 键盘输入功能
     */
    public void input() {
        System.out.println("键盘输入");
    }
}
