package cn.operator; /**
 * 从键盘获取两个数并计算两数之和
 * @author CJ
 */

import java.util.Scanner;//调用scanner

public class TestOperator02 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);//将s定义为scanner函数
        System.out.println("第一个整数是：");//在屏幕上打印这一段话
        int a = s.nextInt();//从键盘获取一个整数
        System.out.println("第二个整数是：");
        int b = s.nextInt();

        int c = a+b;
        System.out.println("两数之和是："+c);
    }
}
