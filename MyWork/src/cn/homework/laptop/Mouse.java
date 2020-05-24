package cn.homework.laptop;

/**
 * 鼠标
 * 实现点击功能
 * @version 2020-5-5
 * @author CJ
 */
public class Mouse implements Usb{

    @Override
    public void powerOn() {
        System.out.println("鼠标连接");
    }

    @Override
    public void powerOff() {
        System.out.println("鼠标关闭");
    }

    /**
     * 鼠标点击功能
     */
    public void click() {
        System.out.println("鼠标点击");
    }
}
