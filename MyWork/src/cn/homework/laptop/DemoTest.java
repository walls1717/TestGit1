package cn.homework.laptop;

/**
 * 测试类
 * @version 2020-5-5
 * @author CJ
 */
public class DemoTest {
    public static void main(String[] args) {
        //创建两个Usb接口
        var usb = new Usb[2];
        //第一个接口插入鼠标
        usb[0] = new Mouse();
        //第二个接口插入键盘
        usb[1] = new Keyboard();
        //创建电脑对象
        var laptop = new Laptop();

        laptop.powerOn();
        laptop.useUsb(usb[0]);
        laptop.useUsb(usb[1]);
        System.out.println();
        laptop.closeUsb(usb[0]);
    }
}
