package cn.homework.computer;

public class Mouse implements Usb {
    @Override
    public void turnOn() {
        System.out.println("鼠标开启");
    }

    @Override
    public void turnOff() {
        System.out.println("鼠标关闭");
    }
}
