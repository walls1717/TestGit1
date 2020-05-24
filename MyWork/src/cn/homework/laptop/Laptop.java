package cn.homework.laptop;

/**
 * 笔记本电脑
 * @version 2020-5-5
 * @author CJ
 */
public class Laptop {
    private Mouse mouse;
    private Keyboard keyboard;

    /**
     * 使用一个Usb接口
     * @param usb Usb接口
     */
    public void useUsb(Usb usb) {
        //先启动Usb接口
        usb.powerOn();
        //判断插入的是鼠标，那么实现鼠标点击功能
        if(usb instanceof Mouse) {
            mouse = (Mouse) usb;
            mouse.click();
        }
        //如果是键盘，实现键盘输入功能
        if(usb instanceof Keyboard) {
            keyboard = (Keyboard) usb;
            keyboard.input();
        }
    }

    /**
     * 关闭一个Usb接口
     * @param usb Usb接口
     */
    public void closeUsb(Usb usb) {
        usb.powerOff();
    }

    public void powerOn() {
        System.out.println("电脑开机");
    }

    /**
     * 电脑关机
     * Usb接口随之关闭
     */
    public void powerOff() {
        System.out.println("电脑关机");
        mouse.powerOff();
        keyboard.powerOff();
    }
}
