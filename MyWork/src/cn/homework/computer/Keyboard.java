package cn.homework.computer;

public class Keyboard implements Usb {
    @Override
    public void turnOn() {
        System.out.println("键盘开启");
    }

    @Override
    public void turnOff() {
        System.out.println("键盘关闭");
    }
}
