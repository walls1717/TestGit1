package cn.homework.laptop;

/**
 * 实现打开设备，关闭设备
 * @version 2020-5-5
 * @author CJ
 */
public interface Usb {
    /**
     * 开启设备
     *
     */
    void powerOn();

    /**
     * 关闭设备
     */
    void powerOff();
}
