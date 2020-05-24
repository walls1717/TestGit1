package cn.circle.test;//包名

import cn.circle.Circle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        //从键盘获取半径
        Scanner s = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        double r = s.nextDouble();
        Circle circle = new Circle();//创建一个新的对象
        //分别调用Circle类中的计算面积与周长的方法并且以四舍五入的方式打印结果
        System.out.println("圆的面积是："+Math.round((circle.getArea(r))));
        System.out.println("圆的周长是："+Math.round((circle.getPerimeter(r))));
    }
}
