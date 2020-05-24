package cn.homework.computer;

public class Computer {
    private Usb[] usbArr = new Usb[4]; //电脑上有四个Usb接口

    public void addUsb(Usb usb) {
        for(int i = 0; i < usbArr.length; i++) {
            if(usbArr[i] == null) {
                usbArr[i] = usb;
                break;
            }
        }
    }

    public void turnOn() {
        System.out.println("电脑开启");
        for(int i = 0; i < usbArr.length; i++) {
            if (usbArr[i] != null) {
                usbArr[i].turnOn();
            }
        }
    }
    public void turnOff() {
        System.out.println("电脑关闭");
        for(int i = 0; i < usbArr.length; i++) {
            if (usbArr[i] != null) {
                usbArr[i].turnOff();
            }
        }
    }
}
