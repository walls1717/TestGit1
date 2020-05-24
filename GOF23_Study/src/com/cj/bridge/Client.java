package com.cj.bridge;

/**
 * @author CJ
 */

public class Client {
    public static void main(String[] args) {
        //销售联想的笔记本电脑
        Computer02 c = new Laptop2(new Lenovo());
        c.sale();

        //销售神州电脑
        Computer02 c2 = new Desktop2(new Shenzhou());
        c2.sale();
    }
}
