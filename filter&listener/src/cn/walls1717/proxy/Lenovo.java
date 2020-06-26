package cn.walls1717.proxy;

/**
 * 真实类
 * @version 2020-6-26
 * @author CJ
 */
public class Lenovo implements SaleComputer {
    @Override
    public String sale(double money) {
        System.out.println("花了"+ money +"买了一台联想电脑");
        return "联想电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑...");
    }
}
