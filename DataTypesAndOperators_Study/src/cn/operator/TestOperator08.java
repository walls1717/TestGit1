package cn.operator; /**
 * 从键盘获取两个数并用关系符比较
 * @author CJ
 */

import java.util.Scanner;

public class TestOperator08 {
    public static void main(String[] args){

        //从键盘获取两个数
        Scanner s = new Scanner(System.in);
        System.out.println("请输入第一个整数：");
        int a = s.nextInt();
        System.out.println("请输入第二个整数：");
        int b = s.nextInt();

        //进行比较
        System.out.println("比较a>b:"+(a>b));
        System.out.println("比较a>=b:"+(a>=b));
        System.out.println("比较a<b:"+(a<b));
        System.out.println("比较a<=b:"+(a<=b));
        System.out.println("比较a==b:"+(a==b));
        System.out.println("比较a!=b:"+(a!=b));
    }
}
