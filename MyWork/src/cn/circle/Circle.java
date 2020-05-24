package cn.circle;//包名为cn.circle

import java.util.Scanner;

public class Circle {
    double area;//面积
    double perimeter;//周长

    //计算面积的方法
    public double getArea(double r){
        area = Math.PI * r * r;
        return area;
    }
    //计算周长的方法
    public double getPerimeter(double r){
        perimeter = 2 * Math.PI *r;
        return perimeter;
    }

    public static void main(String[] args){
        //从键盘获取半径
        Scanner s = new Scanner(System.in);
        double x = s.nextDouble();
        //创建两个新对象，以便调用对应方法
        Circle a = new Circle();
        Circle p = new Circle();
        //调用计算面积跟周长的方法并打印结果
        System.out.println(a.getArea(x));
        System.out.println(p.getPerimeter(x));
    }
}
