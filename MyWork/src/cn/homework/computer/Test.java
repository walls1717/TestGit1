package cn.homework.computer;

public class Test {
    public static void main(String[] args) {
        //创建电脑
        Computer computer = new Computer();
        //添加键盘
        computer.addUsb(new Keyboard());
        //添加鼠标
        computer.addUsb(new Mouse());
        //电脑开启
        computer.turnOn();

        System.out.println();

        //电脑关闭
        computer.turnOff();
    }
}
