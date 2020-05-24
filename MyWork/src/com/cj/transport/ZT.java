package com.cj.transport;

/**
 * 具体的运输人员
 */
public class ZT extends Car{
    @Override
    public void car() {
        Send send = new Send();
        send.send("北京");
        System.out.println("中通车辆运输中");
        send.sendAfter();
    }
}
